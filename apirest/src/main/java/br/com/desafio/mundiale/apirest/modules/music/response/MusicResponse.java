package br.com.desafio.mundiale.apirest.modules.music.response;

import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import lombok.Data;

@Data
public class MusicResponse extends MusicRequest {

    private Long id;

}
