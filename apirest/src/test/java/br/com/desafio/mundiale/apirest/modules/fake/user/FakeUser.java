package br.com.desafio.mundiale.apirest.modules.fake.user;

import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.modules.fake.playlist.FakePlaylist;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.update.UserUpdate;
import com.github.javafaker.Faker;

import java.util.List;

/**
 * Utilizado para gerar dados falsos
 */

public class FakeUser {

    final static Faker faker = new Faker();

    public static User generate() {
        final var user = new User();

        user.setId(1L);
        user.setName("Dados Pessoais");
        user.setEmail("Email pessoal");
//        user.setPlaylists(List.of(FakePlaylist.generate()));

        return user;
    }

    public static UserRequest generateUserRequest() {
        final var userRequest = new UserRequest();

        userRequest.setName("Dados pessoais");
        userRequest.setEmail("Email pessoal");

        return userRequest;
    }

    public static UserResponse generateUserResponse() {
        final var userResponse = new UserResponse();

        userResponse.setId(1L);
        userResponse.setName("Dados Pessoais");
        userResponse.setEmail("Email pessoal");

        return userResponse;
    }

    public static UserUpdate generateUserUpdate() {
        final var userUpdate = new UserUpdate();

        userUpdate.setName("Dados Pessoais");
        userUpdate.setEmail("Email pessoal");

        return userUpdate;
    }
}
