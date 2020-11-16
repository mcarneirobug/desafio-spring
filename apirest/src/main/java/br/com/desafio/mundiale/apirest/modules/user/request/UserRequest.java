package br.com.desafio.mundiale.apirest.modules.user.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRequest {

    @ApiModelProperty(value = "Nome da pessoa", required = true, example = "Matheus")
    @NotNull(message = "Favor informar o nome.")
    private String name;

    @ApiModelProperty(value = "E-mail da pessoa", required = true, example = "matheus@mundiale.com.br")
    @NotNull(message = "Favor informar o e-mail.")
    private String email;
}
