package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

    Pessoa findByCpf(String cpf);
}
