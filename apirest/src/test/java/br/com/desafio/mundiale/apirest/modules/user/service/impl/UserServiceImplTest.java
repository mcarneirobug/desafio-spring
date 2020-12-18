package br.com.desafio.mundiale.apirest.modules.user.service.impl;

import br.com.desafio.mundiale.apirest.ApirestApplication;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.model.repositories.UserRepository;
import br.com.desafio.mundiale.apirest.modules.fake.user.FakeUser;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(
        classes = ApirestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void shouldCreate() {

        final var userRequest = FakeUser.generateUserRequest();
        final var user = FakeUser.generate();

        when(this.userRepository.save(any(User.class))).thenReturn(user);

        final var response = this.userService.create(userRequest);
        assertNotNull(response);

        verify(this.userRepository, times(1)).save(any(User.class));
    }

    @Test
    void shouldSearchAll() {

        final var user = FakeUser.generate();

        when(this.userRepository.findAll()).thenReturn(List.of(user));

        final var response = this.userService.searchAll();
        assertNotNull(response);
        assertFalse(response.isEmpty());

        verify(this.userRepository, times(1)).findAll();
    }

    @Test
    void shouldSearchById() throws NotFoundException {

        final var user = FakeUser.generate();

        when(this.userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        final var response = this.userService.searchById(1L);
        assertNotNull(response);

        verify(this.userRepository, times(1)).findById(anyLong());
    }

    @Test
    void shouldSearchByIdWhenNotFoundExceptionExists() {

        when(this.userRepository.findById(anyLong())).thenReturn(Optional.empty());

        final var exception = assertThrows(NotFoundException.class, () ->
                this.userService.searchById(1L), "Deve retornar um NotFoundException!");

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Não foi encontrado nenhum usuário com o id informado."));

        verify(this.userRepository, times(1)).findById(anyLong());
    }

    @Test
    void shouldSearchAllPlaylist() throws NotFoundException {

        final var user = FakeUser.generate();

        when(this.userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        final var response = this.userService.searchAllPlaylist(1L);
        assertNotNull(response);
        assertFalse(response.isEmpty());

        verify(this.userRepository, times(1)).findById(anyLong());
    }

    @Test
    void shouldSearchAllPlaylistWhenNotFoundExceptionExists() {

        when(this.userRepository.findById(anyLong())).thenReturn(Optional.empty());

        final var exception = assertThrows(NotFoundException.class, () ->
                this.userService.searchAllPlaylist(1L), "Deve retornar um NotFoundException!");

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Não foi encontrado nenhum usuário com o id informado."));

        verify(this.userRepository, times(1)).findById(anyLong());
    }

    @Test
    void shouldUpdate() throws NotFoundException {

        final var user = FakeUser.generate();
        final var userUpdate = FakeUser.generateUserUpdate();

        when(this.userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(this.userRepository.save(any(User.class))).thenReturn(user);

        final var response = this.userService.update(1L, userUpdate);
        assertNotNull(response);

        verify(this.userRepository, times(1)).findById(anyLong());
        verify(this.userRepository, times(1)).save(any(User.class));
    }

    @Test
    void shouldUpdateWhenNotFoundExceptionExists() {

        final var userUpdate = FakeUser.generateUserUpdate();

        when(this.userRepository.findById(anyLong())).thenReturn(Optional.empty());

        final var exception = assertThrows(NotFoundException.class, () ->
                this.userService.update(1L, userUpdate));

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Não foi encontrado nenhum usuário com o id informado."));

        verify(this.userRepository, times(1)).findById(anyLong());
    }
}
