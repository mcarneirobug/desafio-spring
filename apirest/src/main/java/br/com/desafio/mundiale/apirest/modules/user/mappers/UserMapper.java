package br.com.desafio.mundiale.apirest.modules.user.mappers;

import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.modules.playlist.mappers.PlaylistMapper;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;

import java.util.stream.Collectors;

public class UserMapper {

    /**
     * Transformar de User para UserResponse
     * @param user
     * @return userResponse
     */
    public static UserResponse toResponse(User user) {
        final var userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        if(user.getPlaylists() != null) {
            final var playlistResponse =
                    user.getPlaylists()
                            .stream()
                            .map(PlaylistMapper::toResponse)
                            .collect(Collectors.toList());

            userResponse.setPlaylists(playlistResponse);
        }

        return userResponse;
    }

    /**
     * Mudando uma request para Entidade
     * @param userRequest
     * @return User
     */
    public static User to(UserRequest userRequest) {
        final var user = new User();

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPlaylists(user.getPlaylists());

        return user;
    }

}
