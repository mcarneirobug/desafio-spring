package br.com.desafio.mundiale.apirest.modules.playlist.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PlaylistRequest {

    @ApiModelProperty(value = "Nome da playlist", required = true)
    @JsonProperty("name")
    @NotNull(message = "Favor informar o nome.")
    private String name;

    @ApiModelProperty(value = "Descrição da playlist")
    @JsonProperty("description")
    @Size(min = 10, max = 250, message = "A descrição deve conter de 10 a 250 caracteres")
    @NotNull(message = "Informe a descrição.")
    private String description;

    @ApiModelProperty(value = "Nota da playlist")
    @JsonProperty("ratingPlaylist")
    private int ratingPlaylist;

    @ApiModelProperty(value = "Id do usuário criador da playlist")
    @JsonProperty("idUserWhoCreated")
    @NotNull(message = "Deve-se ter usuário.")
    private Long id_user_who_created;
}
