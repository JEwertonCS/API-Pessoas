package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

    Page<Pessoa> findByCpf(String cpf, Pageable pageable);
    List<Pessoa> findByCpf(String cpf);

}
