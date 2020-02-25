package com.stefanini.desafio.controller;

import com.stefanini.desafio.controller.dto.AtualizaPessoaDto;
import com.stefanini.desafio.controller.dto.AtualizaPessoaEnderecoDto;
import com.stefanini.desafio.controller.dto.PessoaDto;
import com.stefanini.desafio.controller.dto.PessoaEnderecoDto;
import com.stefanini.desafio.controller.form.AtualizaPessoaEnderecoForm;
import com.stefanini.desafio.controller.form.AtualizaPessoaForm;
import com.stefanini.desafio.controller.form.PessoaEnderecoForm;
import com.stefanini.desafio.controller.form.PessoaForm;
import com.stefanini.desafio.helper.Util;
import com.stefanini.desafio.model.Pessoa;
import com.stefanini.desafio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/pessoas/versao2" )
public class PessoaEnderecoController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public Page<PessoaEnderecoDto> listar(@RequestParam(required = false) String cpf,
                                          @PageableDefault( page = 0, size = 30, sort = "id", direction = Sort.Direction.ASC)  Pageable pageable){

        Page<Pessoa> pessoas = null;
        if ( cpf == null ) {
            pessoas = pessoaRepository.findAll( pageable );
            return PessoaEnderecoDto.converter(pessoas);
        } else {
            pessoas = pessoaRepository.findByCpf(Util.formatarCPF(cpf), pageable );
            return PessoaEnderecoDto.converter( pessoas );
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PessoaEnderecoForm pessoaForm, UriComponentsBuilder uriBuilder){
        Pessoa pessoa = pessoaForm.converter();
        List<Pessoa> pessoaExistente = pessoaRepository.findByCpf( pessoa.getCpf() );

        if ( pessoaExistente.size() == 0 ) {
            pessoaRepository.save(pessoa);
            URI uri = uriBuilder.path("/pessoas-enderecos/{id}").buildAndExpand( pessoa.getId() ).toUri();
            return ResponseEntity.created( uri ).body( new PessoaEnderecoDto(pessoa) );
        } else {
            return ResponseEntity.badRequest().body("CPF já cadastrado!");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar( @PathVariable String id, @RequestBody @Valid AtualizaPessoaEnderecoForm pessoaForm ){
        Optional optional = pessoaRepository.findById( id );

        if ( optional.isPresent() ){
            Pessoa pessoa = pessoaForm.atualizar( id, pessoaRepository );
            return ResponseEntity.ok().body(new AtualizaPessoaEnderecoDto( pessoa ));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity<?> deletar( @PathVariable String id ) {
        Optional optional = pessoaRepository.findById( id );

        if ( optional.isPresent() ) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
