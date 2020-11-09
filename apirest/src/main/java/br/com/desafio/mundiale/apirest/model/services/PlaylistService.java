package br.com.desafio.mundiale.apirest.model.services;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.repositories.PlaylistRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Playlist create(Playlist playlist) {
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
