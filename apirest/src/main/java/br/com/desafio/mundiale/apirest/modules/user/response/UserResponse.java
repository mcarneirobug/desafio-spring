package br.com.desafio.mundiale.apirest.modules.user.response;

import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data // vem com tudo ToString, hashCode, getter, setter
@JsonInclude(JsonInclude.Include.NON_EMPTY) // tudo que for vazio ele vai ignorar
public class UserResponse extends UserRequest {

    private Long id;

    private List<PlaylistResponse> playlists = new ArrayList<>();

}
