package br.com.desafio.mundiale.apirest.modules.user.controller;

import br.com.desafio.mundiale.apirest.ApirestApplication;
import br.com.desafio.mundiale.apirest.modules.fake.user.FakeUser;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.*;

@SpringBootTest(
        classes = ApirestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureWebTestClient
public class UserControllerTest {

    /**
     * Responsável por fazer requisições HTTP para o Controller
     */

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserService userService;

    @Test
    void shouldCreateUser() {
        final var userRequest = FakeUser.generateUserRequest();
        final var userResponse = FakeUser.generateUserResponse();

        when(this.userService.create(userRequest)).thenReturn(userResponse);

        this.webTestClient.post()
                .uri("/api/user/create")
                .bodyValue(userRequest) // obj esperado no controller
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UserResponse.class) // obj esperado na resposta
                .isEqualTo(userResponse);

        verify(this.userService, times(1)).create(userRequest);
    }

    @Test
    void shouldGetUser() throws NotFoundException {
        final var user = FakeUser.generate();
        final var userResponse = FakeUser.generateUserResponse();

        when(this.userService.searchById(anyLong())).thenReturn(user);

        this.webTestClient
                .get()
                .uri("/api/user/{id}", 1L)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserResponse.class)
                .isEqualTo(userResponse);

        verify(this.userService, times(1)).searchById(anyLong());
    }

    @Test
    void shouldUpdateUser() throws NotFoundException {
        final var userUpdate = FakeUser.generateUserUpdate();
        final var userResponse = FakeUser.generateUserResponse();

        when(this.userService.update(1L, userUpdate)).thenReturn(userResponse);

        this.webTestClient
                .put()
                .uri("/api/user/{idUser}", 1L)
                .bodyValue(userUpdate)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserResponse.class)
                .isEqualTo(userResponse);

        verify(this.userService, times(1)).update(1L, userUpdate);
    }
}
