package br.com.desafio.mundiale.apirest.modules.playlist.controllers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.playlist.mappers.PlaylistMapper;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.services.PlaylistService;
import br.com.desafio.mundiale.apirest.modules.playlist.update.PlaylistUpdate;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/create")
    public PlaylistResponse create(@Valid @RequestBody PlaylistRequest playlistRequest) throws NotFoundException {
        return this.playlistService.create(playlistRequest);
    }

    @GetMapping("/list")
    public List<PlaylistResponse> index() {
        return this.playlistService.searchAll();
    }

    @GetMapping("/{id}")
    public PlaylistResponse getById(@PathVariable Long id) throws NotFoundException {
        return PlaylistMapper.toResponse(this.playlistService.searchById(id));
    }

    @PostMapping("/associateSong/{idPlaylist}/{idMusic}")
    public PlaylistResponse associateSong(@PathVariable Long idPlaylist, @PathVariable Long idMusic) throws NotFoundException {
        return this.playlistService.associateMusic(idPlaylist, idMusic);
    }

    @GetMapping("/getAllMusics/{idPlaylist}")
    public PlaylistResponse getAllMusics(@PathVariable Long idPlaylist) throws NotFoundException {
        return this.playlistService.searchAllMusic(idPlaylist);
    }

    @PutMapping("/{id}")
    public PlaylistResponse update(@PathVariable Long id, @RequestBody PlaylistUpdate playlistUpdate) throws NotFoundException {
        return PlaylistMapper.toResponse(this.playlistService.update(id, playlistUpdate));
    }


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
