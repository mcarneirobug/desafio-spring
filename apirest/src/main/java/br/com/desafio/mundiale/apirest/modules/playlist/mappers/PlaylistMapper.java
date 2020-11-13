package br.com.desafio.mundiale.apirest.modules.playlist.mappers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.update.PlaylistUpdate;

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
     * Método responsável por pegar apenar as músicas
     * de determina playlist
     *
     * Solução proposta é criar uma PlaylistResponse Custom
     * Para eu pegar somente as músicas
     *
     *
     * @param playlist
     * @return PlaylistResponse com os campos que eu quero
     */
    public static PlaylistResponse toResponseOnlyMusic(Playlist playlist) {
        final var playlistResponse = new PlaylistResponse();
        playlistResponse.setMusics(playlist.getMusics());

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

    public static Playlist of (PlaylistUpdate playlistUpdate) {
        final Playlist playlist = new Playlist();
        playlist.setId(playlistUpdate.getId());
        playlist.setName(playlistUpdate.getName());
        playlist.setDescription(playlistUpdate.getDescription());
        playlist.setRatingPlaylist(playlistUpdate.getRatingPlaylist());
        // conferir essa linha
//        playlistUpdate.setId_user_who_created(playlistUpdate.getId_user_who_created());

        return playlist;
    }
}
