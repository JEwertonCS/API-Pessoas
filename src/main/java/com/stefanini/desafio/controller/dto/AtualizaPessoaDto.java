package com.stefanini.desafio.controller.dto;

import com.stefanini.desafio.model.Pessoa;
import com.stefanini.desafio.model.Sexo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AtualizaPessoaDto {

    private String nome;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
    private String email;
    private LocalDateTime dataUltimaAlteracao;

    public AtualizaPessoaDto(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.sexo = pessoa.getSexo();
        this.dataNascimento = pessoa.getDataNascimento();
        this.naturalidade = pessoa.getNaturalidade();
        this.nacionalidade = pessoa.getNacionalidade();
        this.cpf = pessoa.getCpf();
        this.email = pessoa.getEmail();
        this.dataUltimaAlteracao = pessoa.getDataUltimaAlteracao();
    }

    public static List<AtualizaPessoaDto> converter(List<Pessoa> pessoas) {
        return pessoas.stream().map( AtualizaPessoaDto::new ).collect(Collectors.toList());
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

    public LocalDateTime getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }
}
