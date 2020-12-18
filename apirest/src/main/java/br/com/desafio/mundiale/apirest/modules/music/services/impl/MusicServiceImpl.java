package br.com.desafio.mundiale.apirest.modules.music.services.impl;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.model.repositories.MusicRepository;
import br.com.desafio.mundiale.apirest.modules.music.mappers.MusicMapper;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.music.services.MusicService;
import br.com.desafio.mundiale.apirest.modules.music.update.MusicUpdate;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public MusicResponse create(MusicRequest musicRequest) {
        final var music = this.musicRepository.save(MusicMapper.to(musicRequest));
        return MusicMapper.toResponse(music);
    }

    @Override
    public List<MusicResponse> searchAll() {
        return this.musicRepository.findAll()
                .stream()
                .map(MusicMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Music searchById(Long id) throws NotFoundException {
        return this.musicRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhuma música com o id informado."));
    }

    @Override
    public Music update(Long idMusic, MusicUpdate musicUpdate) throws NotFoundException {
        final var music = this.searchById(idMusic);

        music.setName(musicUpdate.getName());
        music.setSinger(musicUpdate.getSinger());
        music.setReleaseMusic(musicUpdate.getReleaseMusic());
        music.setRatingMusic(musicUpdate.getRatingMusic());

        return this.musicRepository.save(music);
    }

    @Override
    public void remove(Long idMusic) throws NotFoundException {
        final var music = this.searchById(idMusic);
        this.musicRepository.deleteById(music.getId());
    }
}
