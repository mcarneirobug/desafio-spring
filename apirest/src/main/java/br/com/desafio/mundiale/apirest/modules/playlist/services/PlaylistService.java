package br.com.desafio.mundiale.apirest.modules.playlist.services;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
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

    List<MusicResponse> searchAllMusic(Long idPlaylist) throws NotFoundException;

    Playlist update(Long idPlaylist, PlaylistUpdate playlistUpdate) throws NotFoundException;

    Playlist removeMusic(Long idPlaylist, PlaylistUpdate playlistUpdate) throws NotFoundException;

    void remove(Long idPlaylist) throws NotFoundException;
}
