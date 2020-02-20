package com.stefanini.desafio.controller.config.validacao;

public class ErroDeValidacao {
    private String campo;
    private String erro;

    public ErroDeValidacao(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
