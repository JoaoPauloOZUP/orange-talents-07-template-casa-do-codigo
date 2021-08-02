package br.com.zupacademy.joao.casadocodigo.controller.dto.request;

import br.com.zupacademy.joao.casadocodigo.model.Cliente;
import br.com.zupacademy.joao.casadocodigo.model.Estado;
import br.com.zupacademy.joao.casadocodigo.model.Pais;
import br.com.zupacademy.joao.casadocodigo.validator.campounico.UniqueValue;
import br.com.zupacademy.joao.casadocodigo.validator.cpfoucnpj.CpfCnjValue;
import br.com.zupacademy.joao.casadocodigo.validator.paisestado.PaisEstadoExistValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;


public class ClienteRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobreNome;

    @NotBlank
    @CpfCnjValue(domainClass = Cliente.class, fieldName = "documento")
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @JsonProperty("localidade")
    private LocalidadeRequest localidadeRequest;

    @NotBlank
    @Pattern(regexp = "[0-9]{2}-[0-9]{8,9}", message = "Formatação incorreta. Ex: 99-999999999")
    private String telefone;

    @NotBlank
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "Formatação incorreta. Ex: 99999-999")
    private String cep;

    public ClienteRequest( @NotBlank @Email String email,
                           @NotBlank String nome,
                           @NotBlank String sobreNome,
                           @NotBlank String documento,
                           @NotBlank String endereco,
                           @NotBlank String complemento,
                           @NotBlank String cidade,
                           LocalidadeRequest localidadeRequest,
                           @NotBlank String telefone,
                           @NotBlank String cep) {

        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.localidadeRequest = localidadeRequest;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalidadeRequest getLocalidadeRequest() {
        return localidadeRequest;
    }

    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, this.localidadeRequest.getPaisId());

        if(this.localidadeRequest.getEstadoId() != null) {
            Estado estado = manager.find(Estado.class, this.localidadeRequest.getEstadoId());
            return new Cliente(this.email, this.nome, this.sobreNome, this.documento, this.endereco, this. complemento, this.cidade, pais, estado, this.telefone, this.cep);
        }

        return new Cliente(this.email, this.nome, this.sobreNome, this.documento, this.endereco, this. complemento, this.cidade, pais, this.telefone, this.cep);
    }
}