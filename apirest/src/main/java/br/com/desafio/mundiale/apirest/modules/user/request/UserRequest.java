package br.com.desafio.mundiale.apirest.modules.user.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRequest {

    @NotNull(message = "Favor informar o nome.")
    private String name;

    @NotNull(message = "Favor informar o e-mail.")
    private String email;
}
