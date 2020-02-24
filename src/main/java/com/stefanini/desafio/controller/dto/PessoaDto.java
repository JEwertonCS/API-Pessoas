package com.stefanini.desafio.controller.dto;

import com.stefanini.desafio.model.Pessoa;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class PessoaDto {

    private String id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
    private String email;

    public PessoaDto ( Pessoa pessoa ) {
        this.id = pessoa.getId();
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

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
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
