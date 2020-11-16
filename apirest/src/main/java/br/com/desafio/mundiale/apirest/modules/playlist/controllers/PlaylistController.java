package br.com.desafio.mundiale.apirest.modules.playlist.controllers;

import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.mappers.PlaylistMapper;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.services.PlaylistService;
import br.com.desafio.mundiale.apirest.modules.playlist.update.PlaylistUpdate;
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
    public List<MusicResponse> getAllMusics(@PathVariable Long idPlaylist) throws NotFoundException {
        return this.playlistService.searchAllMusic(idPlaylist);
    }

    @PutMapping("/{idPlaylist}")
    public PlaylistResponse update(@PathVariable Long idPlaylist, @Valid @RequestBody PlaylistUpdate playlistUpdate) throws NotFoundException {
        return PlaylistMapper.toResponse(this.playlistService.update(idPlaylist, playlistUpdate));
    }

    @DeleteMapping("/{idPlaylist}")
    public void delete(@PathVariable Long idPlaylist) throws NotFoundException {
        this.playlistService.remove(idPlaylist);
    }

    @PutMapping("/removeMusic/{idPlaylist}")
    public PlaylistResponse removeMusic(@PathVariable Long idPlaylist, @Valid @RequestBody PlaylistUpdate playlistUpdate) throws NotFoundException {
        return PlaylistMapper.toResponse(this.playlistService.removeMusic(idPlaylist, playlistUpdate));
    }
}
