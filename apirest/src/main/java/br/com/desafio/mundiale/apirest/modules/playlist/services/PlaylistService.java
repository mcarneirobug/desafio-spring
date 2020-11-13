package br.com.desafio.mundiale.apirest.modules.playlist.services;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.update.PlaylistUpdate;
import javassist.NotFoundException;

import java.util.List;

public interface PlaylistService {

    List<PlaylistResponse> searchAll();

    PlaylistResponse create(PlaylistRequest playlistRequest) throws NotFoundException;

    Playlist searchById(Long id) throws NotFoundException;

    PlaylistResponse associateMusic(Long idPlaylist, Long idMusic) throws NotFoundException;

    // Método proposto para a partir de uma playlist listar somente suas músicas
    PlaylistResponse searchAllMusic(Long idPlaylist) throws NotFoundException;

    Playlist update(Long id, PlaylistUpdate playlistUpdate) throws NotFoundException;
}
