package br.com.desafio.mundiale.apirest.modules.user.services;

import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {
    List<UserResponse> searchAll();

    UserResponse create(UserRequest userRequest);

    User searchById(Long id) throws NotFoundException;

    List<PlaylistResponse> searchAllPlaylist(Long idUser) throws NotFoundException;

}
