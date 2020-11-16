package br.com.desafio.mundiale.apirest.modules.playlist.mappers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.modules.music.mappers.MusicMapper;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;

import java.util.stream.Collectors;

public class PlaylistMapper {

    /**
     * Transformar de Playlist para PlaylistResponse
     * @param playlist
     * @return - PlaylistResponse
     */
    public static PlaylistResponse toResponse(Playlist playlist) {

        final var playlistResponse = new PlaylistResponse();

        playlistResponse.setId(playlist.getId());
        playlistResponse.setName(playlist.getName());
        playlistResponse.setDescription(playlist.getDescription());
        playlistResponse.setRatingPlaylist(playlist.getRatingPlaylist());
        if(playlist.getMusics() != null) {
            final var music =
                    playlist.getMusics()
                            .stream()
                            .map(MusicMapper::toResponse)
                            .collect(Collectors.toList());
            playlistResponse.setMusics(music);
        }
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
        playlist.setId_user_who_created(user);

        return playlist;
    }
}
