package br.com.desafio.mundiale.apirest.modules.music.mappers;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;

public class MusicMapper {


    /**
     * Converter de Music para MusicResponse
     * @param music
     * @return - new Music Response
     */
    public static MusicResponse toResponse(Music music) {

        final var musicResponse = new MusicResponse();

        musicResponse.setId(music.getId());
        musicResponse.setName(music.getName());
        musicResponse.setSinger(music.getSinger());
        musicResponse.setRatingMusic(music.getRatingMusic());
        musicResponse.setReleaseMusic(music.getReleaseMusic());

        return musicResponse;
    }

    /**
     * Mudando uma MusicRequest para uma Entidade
     * @param musicRequest
     * @return Music
     */
    public static Music to(MusicRequest musicRequest) {

        final var music = new Music();

        music.setName(musicRequest.getName());
        music.setSinger(musicRequest.getSinger());
        music.setRatingMusic(musicRequest.getRatingMusic());
        music.setReleaseMusic(musicRequest.getReleaseMusic());

        return music;
    }
}
