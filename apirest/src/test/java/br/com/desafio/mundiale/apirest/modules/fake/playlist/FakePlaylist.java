package br.com.desafio.mundiale.apirest.modules.fake.playlist;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.fake.user.FakeUser;

public class FakePlaylist {

    public static Playlist generate() {
        final var playlist = new Playlist();
        playlist.setId(1L);
        playlist.setName("playlist");
        playlist.setDescription("description");
        playlist.setRatingPlaylist(10);
        playlist.setId_user_who_created(FakeUser.generate());

        return playlist;
    }

}
