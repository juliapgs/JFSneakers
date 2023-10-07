package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public class EnderecoDTO {

    @NotBlank(message = "O campo cep não pode ser nulo.")
    private final String cep;
    
    @NotBlank(message = "O campo logradouro não pode ser nulo.")
    private final String logradouro;

    public EnderecoDTO(String cep, String logradouro) {
        this.cep = cep;
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
        return result;
    }
}
