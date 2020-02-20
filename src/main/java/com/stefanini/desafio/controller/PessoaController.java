package com.stefanini.desafio.controller;

import com.stefanini.desafio.controller.dto.PessoaDto;
import com.stefanini.desafio.controller.form.PessoaForm;
import com.stefanini.desafio.model.Pessoa;
import com.stefanini.desafio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping( "/pessoas" )
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public List<PessoaDto> listar(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return PessoaDto.converter( pessoas );
    }

    @PostMapping
    public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder uriBuilder){
        Pessoa pessoa = pessoaForm.converter();
        Pessoa pessoaExistente = pessoaRepository.findByCpf( pessoa.getCpf() );

        if ( pessoaExistente == null ) {
            pessoaRepository.save(pessoa);
            URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand( pessoa.getId() ).toUri();
            return ResponseEntity.created( uri ).body( new PessoaDto(pessoa) );
        } else {
            return ResponseEntity.badRequest().body( new PessoaDto(pessoa) );
        }
    }

}
