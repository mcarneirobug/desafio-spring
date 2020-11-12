package br.com.desafio.mundiale.apirest.modules.user.response;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data // vem com tudo ToString, hashCode, getter, setter
public class UserResponse extends UserRequest {

    private Long id;

    private List<Playlist> playlists = new ArrayList<>();

}
