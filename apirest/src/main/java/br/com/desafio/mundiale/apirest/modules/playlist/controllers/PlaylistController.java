package br.com.desafio.mundiale.apirest.modules.playlist.controllers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.playlist.mappers.PlaylistMapper;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.services.PlaylistService;
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

    @PostMapping("/create/{id_user}")
    public PlaylistResponse create(@Valid @RequestBody PlaylistRequest playlistRequest) throws NotFoundException {
        return PlaylistMapper.toResponse(this.playlistService.create(playlistRequest));
    }

    @GetMapping("/{id}")
    public Playlist getById(@PathVariable Long id) throws NotFoundException {
        return this.playlistService.searchById(id);
    }

//    @PostMapping("/associateUser/{id_playlist}/{id_user}")
//    public Playlist associate(@PathVariable Long id_playlist, @PathVariable Long id_user) throws NotFoundException {
//        return this.playlistService.associateUser(id_playlist, id_user);
//    }

//    @PostMapping("/associateSong/{id_playlist}/{id_music}")
//    public Playlist associateSong(@PathVariable Long id_playlist, @PathVariable Long id_music) throws NotFoundException {
//        return this.playlistService.associateMusic(id_playlist, id_music);
//    }

//    @GetMapping("/getPlaylistUser/{id_user}")
//    public Playlist getPlaylistUser(@PathVariable Long id_user) throws NotFoundException {
//        return this.playlistService.listAllPlaylist(id_user);
//    }

//    @PostMapping("/associate/{id_playlist}/{id_user}")
//    public Playlist associate(@PathVariable Long id_playlist, @PathVariable Long id_user) throws NotFoundException {
//        return this.playlistService.associate(id_playlist, id_user);
//    }
//
//    @PostMapping("/associatemusic/{id_playlist}/{id_user}")
//    public Playlist associateMusic(@PathVariable Long id_playlist, @PathVariable Long id_user) throws NotFoundException {
//        return this.playlistService.associateMusic(id_playlist, id_user);
//    }

//    @PutMapping("/update/{id}")
//    public Playlist update(@RequestBody Playlist playlist) throws NotFoundException {
//        return this.playlistService.update(playlist);
//    }

}
