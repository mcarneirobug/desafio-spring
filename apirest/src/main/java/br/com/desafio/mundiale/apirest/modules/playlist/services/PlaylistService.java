package br.com.desafio.mundiale.apirest.modules.playlist.services;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import javassist.NotFoundException;

import java.util.List;

public interface PlaylistService {

    List<Playlist> searchAll();

    Playlist create(PlaylistRequest playlistRequest) throws NotFoundException;

    Playlist searchById(Long id) throws NotFoundException;

}
