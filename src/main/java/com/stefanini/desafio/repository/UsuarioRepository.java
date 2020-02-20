package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email );

    Optional<Usuario> findByNome(String s);
}
