package br.com.zupacademy.joao.casadocodigo.config.excptionhandler.dto.response;

public class ErroAutorResponse {

    private String campo;

    private String erro;

    public ErroAutorResponse() { }

    public ErroAutorResponse(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

}
