package com.stefanini.desafio.helper;


import java.util.Base64;

public class Base64Custom {

    public static String codificarStringBase64(String texto){
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }

    public static String decodificarStringBase64(String textoCodificado){
        return new String( Base64.getDecoder().decode(textoCodificado) );
    }

}
