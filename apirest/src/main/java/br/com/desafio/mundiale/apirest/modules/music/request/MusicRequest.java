package br.com.desafio.mundiale.apirest.modules.music.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MusicRequest {

    @ApiModelProperty(value = "Nome da música", required = true)
    @NotBlank(message = "Favor informar o nome.")
    @Size(min = 6, max = 250, message = "O nome deve conter de 6 a 250 caracteres")
    private String name;

    @ApiModelProperty(value = "Nome do cantor", required = true)
    @NotBlank(message = "Favor informar o nome do cantor(a).")
    private String singer;

    @ApiModelProperty(value = "Ano de lançamento")
    private Integer releaseMusic;

    @ApiModelProperty(value = "Nota da música")
    private Integer ratingMusic;
}
