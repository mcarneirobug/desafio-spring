package br.com.desafio.mundiale.apirest.modules.fake.music;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.music.update.MusicUpdate;

public class FakeMusic {

    public static Music generate() {

        final var music = new Music();

        music.setId(1L);
        music.setName("test");
        music.setSinger("test");
        music.setReleaseMusic(10);
        music.setRatingMusic(10);

        return music;
    }

    public static MusicResponse generateMusicResponse() {

        final var musicResponse = new MusicResponse();

        musicResponse.setId(1L);
        musicResponse.setName("test");
        musicResponse.setSinger("test");
        musicResponse.setReleaseMusic(10);
        musicResponse.setRatingMusic(10);

        return musicResponse;
    }

    public static MusicRequest generateMusicRequest() {

        final var musicRequest = new MusicRequest();

        musicRequest.setName("test");
        musicRequest.setSinger("test");
        musicRequest.setReleaseMusic(10);
        musicRequest.setRatingMusic(10);

        return musicRequest;
    }

    public static MusicUpdate generateMusicUpdate() {

        final var musicUpdate = new MusicUpdate();

        musicUpdate.setName("test");
        musicUpdate.setSinger("test");
        musicUpdate.setReleaseMusic(10);
        musicUpdate.setRatingMusic(10);

        return musicUpdate;
    }
}
