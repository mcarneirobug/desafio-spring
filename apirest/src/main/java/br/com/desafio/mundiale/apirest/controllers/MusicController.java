package br.com.desafio.mundiale.apirest.controllers;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.model.services.MusicService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/list")
    public List<Music> index() {
        return this.musicService.searchAll();
    }

    @GetMapping("/{id}")
    public Music getById(@PathVariable Long id) throws NotFoundException {
        return this.musicService.searchById(id);
    }

    @PostMapping("/create")
    public Music create(@RequestBody @Valid Music music) {
        return this.musicService.create(music);
    }

//    @PostMapping("/associateuser/{id_music}/{id_user}")
//    public Music associateUser(@PathVariable Long id_music, @PathVariable Long id_user) throws NotFoundException {
//        return this.musicService.associate(id_music, id_user);
//    }

}
