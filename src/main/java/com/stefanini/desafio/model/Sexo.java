package com.stefanini.desafio.model;

public enum Sexo {
    MASCULINO("MASCULINO"), FEMININO("FEMININO"), NAO_INFORMADO("");

    private final String value;

    Sexo(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static Sexo getDefault() {
        return NAO_INFORMADO;
    }
}
