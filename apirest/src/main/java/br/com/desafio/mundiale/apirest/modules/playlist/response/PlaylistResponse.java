package br.com.desafio.mundiale.apirest.modules.playlist.response;

import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import lombok.Data;

@Data
public class PlaylistResponse extends PlaylistRequest {

    private Long id;

}
