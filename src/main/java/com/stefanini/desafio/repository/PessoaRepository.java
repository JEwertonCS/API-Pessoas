package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

    List<Pessoa> findByCpf(String cpf);

}
