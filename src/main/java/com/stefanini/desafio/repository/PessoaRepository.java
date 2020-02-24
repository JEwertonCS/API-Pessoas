package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

    Page<Pessoa> findByCpf(String cpf, Pageable pageable);
    List<Pessoa> findByCpf(String cpf);

}
