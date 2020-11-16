package br.com.desafio.mundiale.apirest.modules.playlist.update;

import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import lombok.Data;

@Data
public class PlaylistUpdate extends PlaylistRequest {

    private Long idMusic;

}
