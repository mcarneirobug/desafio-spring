package br.com.desafio.mundiale.apirest.controllers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.services.PlaylistService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/list")
    public List<Playlist> index() {
        return this.playlistService.searchAll();
    }

    @PostMapping("/create")
    public Playlist create(@Valid @RequestBody Playlist playlist) {
        return this.playlistService.create(playlist);
    }

    @PostMapping("/associate/{id_playlist}/{id_user}")
    public Playlist associate(@PathVariable Long id_playlist, @PathVariable Long id_user) throws NotFoundException {
        return this.playlistService.associate(id_playlist, id_user);
    }

    @PostMapping("/associatemusic/{id_playlist}/{id_user}")
    public Playlist associateMusic(@PathVariable Long id_playlist, @PathVariable Long id_user) throws NotFoundException {
        return this.playlistService.associateMusic(id_playlist, id_user);
    }

    @PutMapping("/update/{id}")
    public Playlist update(@RequestBody Playlist playlist) throws NotFoundException {
        return this.playlistService.update(playlist);
    }

}
