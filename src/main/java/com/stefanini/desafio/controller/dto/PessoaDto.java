package com.stefanini.desafio.controller.dto;

import com.stefanini.desafio.model.Pessoa;
import com.stefanini.desafio.model.Sexo;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaDto {

    private String nome;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
    private String email;

    public PessoaDto ( Pessoa pessoa ) {
        this.nome = pessoa.getNome();
        this.sexo = pessoa.getSexo();
        this.dataNascimento = pessoa.getDataNascimento();
        this.naturalidade = pessoa.getNaturalidade();
        this.nacionalidade = pessoa.getNacionalidade();
        this.cpf = pessoa.getCpf();
        this.email = pessoa.getEmail();
    }

    public static Page<PessoaDto> converter(Page<Pessoa> pessoas) {
        return pessoas.map( PessoaDto::new );
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
