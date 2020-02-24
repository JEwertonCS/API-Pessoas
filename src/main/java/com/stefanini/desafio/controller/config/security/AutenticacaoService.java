package com.stefanini.desafio.controller.config.security;

import com.stefanini.desafio.model.Usuario;
import com.stefanini.desafio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Usuario> optional = usuarioRepository.findByNome(s);
        if ( optional.isPresent() ){
            return optional.get();
        }
        return null;
       // throw new UsernameNotFoundException("Dados Inválidos!");
    }
}
