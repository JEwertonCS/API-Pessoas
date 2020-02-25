package com.stefanini.desafio.controller.form;

import com.stefanini.desafio.helper.Util;
import com.stefanini.desafio.model.Endereco;
import com.stefanini.desafio.model.Pessoa;
import com.stefanini.desafio.model.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class PessoaEnderecoForm {

    @NotBlank @NotEmpty
    private String nome;

    private Sexo sexo;

    @NotNull @PastOrPresent
    private LocalDate dataNascimento;

    private String naturalidade;
    private String nacionalidade;

    @NotBlank @CPF
    private String cpf;

    @Email( message = "Informe um e-mail válido!" )
    private String email;

    @NotNull
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa converter() {
        return new Pessoa( nome, sexo, dataNascimento, naturalidade, nacionalidade, Util.formatarCPF(cpf), email, endereco );
    }
}
