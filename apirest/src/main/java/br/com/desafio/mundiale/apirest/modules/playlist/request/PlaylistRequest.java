package br.com.desafio.mundiale.apirest.modules.playlist.request;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class PlaylistRequest {

    @NotBlank(message = "Favor informar o nome.")
    private String name;

    @Size(min = 10, max = 250, message = "A descrição deve conter de 10 a 250 caracteres")
    @NotNull(message = "Informe a descrição.")
    private String description;

    private int rating_playlist;

    private List<Music> musics = new ArrayList<>();

    @NotNull(message = "Deve-se ter usuário.")
    private Long id_user_who_created;

}
