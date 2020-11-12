package br.com.desafio.mundiale.apirest.modules.playlist.request;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class PlaylistRequest {

    @JsonProperty("name")
    @NotNull(message = "Favor informar o nome.")
    private String name;

    @JsonProperty("description")
    @Size(min = 10, max = 250, message = "A descrição deve conter de 10 a 250 caracteres")
    @NotNull(message = "Informe a descrição.")
    private String description;

    @JsonProperty("ratingPlaylist")
    private int ratingPlaylist;

    private List<Music> musics = new ArrayList<>();

    @JsonProperty("idUserWhoCreated")
    @NotNull(message = "Deve-se ter usuário.")
    private Long id_user_who_created;

}
