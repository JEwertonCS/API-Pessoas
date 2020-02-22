package com.stefanini.desafio.helper;

public class UsuarioHelper {
    public static String recuperarUsuario(String usarioSenha) {
        String[] arrayUsuarioSenha = usarioSenha.split(":");
        return arrayUsuarioSenha[0];
    }

    public static String recuperarSenha(String usarioSenha) {
        String[] arrayUsuarioSenha = usarioSenha.split(":");
        return arrayUsuarioSenha[1];
    }
}
