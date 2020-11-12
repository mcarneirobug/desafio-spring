package br.com.desafio.mundiale.apirest.modules.playlist.services;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import javassist.NotFoundException;

import java.util.List;

public interface PlaylistService {

    List<PlaylistResponse> searchAll();

    PlaylistResponse create(PlaylistRequest playlistRequest) throws NotFoundException;

    Playlist searchById(Long id) throws NotFoundException;

}
