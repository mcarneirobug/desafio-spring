package br.com.desafio.mundiale.apirest.modules.music.services;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.music.update.MusicUpdate;
import javassist.NotFoundException;

import java.util.List;

public interface MusicService {

    List<MusicResponse> searchAll();

    MusicResponse create(MusicRequest musicRequest);

    Music searchById(Long id) throws NotFoundException;

    Music update(Long idMusic, MusicUpdate musicUpdate) throws NotFoundException;

    void remove(Long idMusic) throws NotFoundException;
}
