package com.stefanini.desafio.controller;

import com.stefanini.desafio.controller.config.security.TokenService;
import com.stefanini.desafio.controller.dto.TokenDto;
import com.stefanini.desafio.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm loginForm){

        UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken( authentication );
            return ResponseEntity.ok( new TokenDto(token, "Basic") );
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
