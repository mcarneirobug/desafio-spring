package br.com.desafio.mundiale.apirest.model.services;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.repositories.PlaylistRepository;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserService userService;

    public Playlist create(Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }

    public Playlist associate(Long id_playlist, Long id_user) throws NotFoundException {
        final var user = userService.searchById(id_user);
        final var playlist = this.searchById(id_playlist);
        playlist.setUser(user);
//        playlist.getUser().getPlaylists().add(playlist);
//        playlist.getMusics().addAll(user.getMusics());
        return this.playlistRepository.save(playlist);
    }

    public Playlist associateMusic(Long id_playlist, Long id_user) throws NotFoundException {
        final var user = userService.searchById(id_user);
        final var playlist = this.searchById(id_playlist);
//        playlist.getMusics().addAll(user.getMusics());
        return this.playlistRepository.save(playlist);
    }

    public List<Playlist> searchAll() {
        return this.playlistRepository.findAll();
    }

    public Playlist searchById(Long id) throws NotFoundException {
        return this.playlistRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhuma playlist com o id informado."));
    }

    public Playlist update(Playlist playlist) throws NotFoundException {
        this.searchById(playlist.getId());
        return this.playlistRepository.save(playlist);
    }

}
