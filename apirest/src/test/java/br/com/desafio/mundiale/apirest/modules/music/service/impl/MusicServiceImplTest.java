package br.com.desafio.mundiale.apirest.modules.music.service.impl;

import br.com.desafio.mundiale.apirest.ApirestApplication;
import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.model.repositories.MusicRepository;
import br.com.desafio.mundiale.apirest.modules.fake.music.FakeMusic;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.music.services.MusicService;
import br.com.desafio.mundiale.apirest.modules.music.update.MusicUpdate;
import javassist.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(
        classes = ApirestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class MusicServiceImplTest {

    @MockBean
    private MusicRepository musicRepository;

    @Autowired
    private MusicService musicService;

    private Music music;

    private MusicRequest musicRequest;

    private MusicResponse musicResponse;

    private MusicUpdate musicUpdate;

    @BeforeEach
    void setUp() {
        music = FakeMusic.generate();
        musicRequest = FakeMusic.generateMusicRequest();
        musicResponse = FakeMusic.generateMusicResponse();
        musicUpdate = FakeMusic.generateMusicUpdate();
    }

    @Test
    void shouldCreate() {

        when(this.musicRepository.save(any(Music.class))).thenReturn(music);

        final var response = this.musicService.create(musicRequest);
        assertNotNull(response);

        verify(this.musicRepository, times(1)).save(any(Music.class));
    }

    @Test
    void shouldSearchAll() {

        when(this.musicRepository.findAll()).thenReturn(List.of(music));

        final var response = this.musicService.searchAll();
        assertNotNull(response);
        assertFalse(response.isEmpty());

        verify(this.musicRepository, times(1)).findAll();
    }

    @Test
    void shouldSearchById() throws NotFoundException {

        when(this.musicRepository.findById(anyLong())).thenReturn(Optional.of(music));

        final var response = this.musicService.searchById(1L);
        assertNotNull(response);

        verify(this.musicRepository, times(1)).findById(anyLong());
    }

    @Test
    void shouldSearchByIdWhenNotFoundExceptionExists() {

        when(this.musicRepository.findById(anyLong())).thenReturn(Optional.empty());

        final var exception = assertThrows(NotFoundException.class, () ->
                this.musicService.searchById(1L), "Deve retornar um NotFoundException.");

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Não foi encontrado nenhuma música com o id informado."));

        verify(this.musicRepository, times(1)).findById(anyLong());
    }

    @Test
    void shouldUpdate() throws NotFoundException {

        when(this.musicRepository.findById(anyLong())).thenReturn(Optional.of(music));
        when(this.musicRepository.save(any(Music.class))).thenReturn(music);

        final var response = this.musicService.update(1L, musicUpdate);
        assertNotNull(response);

        verify(this.musicRepository, times(1)).findById(anyLong());
        verify(this.musicRepository, times(1)).save(any(Music.class));
    }

    @Test
    void shouldUpdateWhenNotFoundExceptionExists() {

        when(this.musicRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(this.musicRepository.save(any(Music.class))).thenReturn(music);

        final var exception = assertThrows(NotFoundException.class, () ->
                this.musicService.update(1L, musicUpdate), "Deve retornar um NotFoundException.");

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Não foi encontrado nenhuma música com o id informado."));

        verify(this.musicRepository, times(1)).findById(anyLong());
        verify(this.musicRepository, times(0)).save(any(Music.class));
    }
    
    @Test
    void shouldRemove() throws NotFoundException {

        when(this.musicRepository.findById(anyLong())).thenReturn(Optional.of(music));
        doNothing().when(this.musicRepository).deleteById(anyLong());

        this.musicService.remove(1L);

        verify(this.musicRepository, times(1)).findById(anyLong());
        verify(this.musicRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void shouldRemoveWhenNotFoundExceptionExists() {

        when(this.musicRepository.findById(anyLong())).thenReturn(Optional.empty());
        doNothing().when(this.musicRepository).deleteById(anyLong());

        final var exception = assertThrows(NotFoundException.class, () ->
                this.musicService.remove(1L), "Deve retornar um NotFoundException.");

        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Não foi encontrado nenhuma música com o id informado."));

        verify(this.musicRepository, times(1)).findById(anyLong());
        verify(this.musicRepository, times(0)).deleteById(anyLong());
    }
}
