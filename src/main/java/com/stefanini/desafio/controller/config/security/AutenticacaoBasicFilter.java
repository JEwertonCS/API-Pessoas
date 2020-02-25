package com.stefanini.desafio.controller.config.security;

import com.stefanini.desafio.helper.Base64Custom;
import com.stefanini.desafio.helper.UsuarioHelper;
import com.stefanini.desafio.model.Usuario;
import com.stefanini.desafio.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoBasicFilter extends OncePerRequestFilter {

    private AutenticacaoService autenticacaoService;
    private UsuarioRepository usuarioRepository;

    public AutenticacaoBasicFilter(AutenticacaoService autenticacaoService, UsuarioRepository usuarioRepository) {
        this.autenticacaoService = autenticacaoService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String usarioSenha = Base64Custom.decodificarStringBase64( recuperarUsuarioSenha(request) );
        String usuario = UsuarioHelper.recuperarUsuario( usarioSenha );
        String senha = UsuarioHelper.recuperarSenha( usarioSenha );

        Usuario user = (Usuario) autenticacaoService.loadUserByUsername( usuario );
        if ( user != null && user.isValido(usuario, senha)){
            autenticarCliente( user );
        }

        filterChain.doFilter( request, response );
    }

    private void autenticarCliente(Usuario user) {
        UsernamePasswordAuthenticationToken autentication =
                new UsernamePasswordAuthenticationToken( user, null, user.getAuthorities() );
        SecurityContextHolder.getContext().setAuthentication( autentication );
    }

    private String recuperarUsuarioSenha(HttpServletRequest request) {
        String codigo = request.getHeader("Authorization");
        if ( codigo == null || codigo.isEmpty() || !codigo.startsWith("Basic ") ){
            return null;
        }

        return codigo.substring( 6, codigo.length() );
    }
}
