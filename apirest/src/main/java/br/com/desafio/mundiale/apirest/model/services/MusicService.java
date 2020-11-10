package br.com.desafio.mundiale.apirest.model.services;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.model.repositories.MusicRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

//    @Autowired
//    private UserService userService;

    public Music create(Music objMusic) {
        return this.musicRepository.save(objMusic);
    }

//    public Music associate(Long id_music, Long id_user) throws NotFoundException {
//        final var user = userService.searchById(id_user);
//        final var music = this.searchById(id_music);
////        music.setUser_music(user);
////        music.getUser_music().getMusics().add(music);
//        return this.musicRepository.save(music);
//    }

    public List<Music> searchAll() {
        return this.musicRepository.findAll();
    }

    public Music searchById(Long id) throws NotFoundException {
        return this.musicRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhuma música com o id informado."));
    }



}
