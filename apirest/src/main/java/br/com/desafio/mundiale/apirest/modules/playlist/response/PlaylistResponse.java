package br.com.desafio.mundiale.apirest.modules.playlist.response;

import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlaylistResponse extends PlaylistRequest {

    private Long id;

    private List<MusicResponse> musics = new ArrayList<>();

}
