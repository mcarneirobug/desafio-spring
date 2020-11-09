package br.com.desafio.mundiale.apirest.model.services;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.model.repositories.MusicRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Music create(Music objMusic) {
        return this.musicRepository.save(objMusic);
    }

    public List<Music> searchAll() {
        return this.musicRepository.findAll();
    }

    public Music searchById(Long id) throws NotFoundException {
        return this.musicRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhuma música com o id informado."));
    }

}
