package br.com.desafio.mundiale.apirest.modules.playlist.mappers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;

public class PlaylistMapper {

    public static PlaylistResponse toResponse(Playlist playlist) {

        final var playlistResponse = new PlaylistResponse();

        playlistResponse.setId(playlist.getId());
        playlistResponse.setName(playlist.getName());
        playlistResponse.setDescription(playlist.getDescription());
        playlistResponse.setRatingPlaylist(playlist.getRatingPlaylist());
        playlistResponse.setMusics(playlist.getMusics());
        playlistResponse.setId_user_who_created(playlist.getId_user_who_created().getId());

        return playlistResponse;
    }

    /**
     * Mudando uma PlaylistRequest para Entidade Playlist
     * @param playlistRequest
     * @return Playlist
     */
    public static Playlist to(PlaylistRequest playlistRequest, User user) {

        final var playlist = new Playlist();

        playlist.setName(playlistRequest.getName());
        playlist.setDescription(playlistRequest.getDescription());
        playlist.setRatingPlaylist(playlistRequest.getRatingPlaylist());
        playlist.setMusics(playlistRequest.getMusics());
        playlist.setId_user_who_created(user);

        return playlist;
    }

}
