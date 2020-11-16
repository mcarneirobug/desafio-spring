package br.com.desafio.mundiale.apirest.modules.music.controllers;

import br.com.desafio.mundiale.apirest.modules.music.mappers.MusicMapper;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.music.services.MusicService;
import br.com.desafio.mundiale.apirest.modules.music.update.MusicUpdate;
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
    public List<MusicResponse> index() {
        return this.musicService.searchAll();
    }

    @PostMapping("/create")
    public MusicResponse create(@RequestBody @Valid MusicRequest musicRequest) {
        return this.musicService.create(musicRequest);
    }

    @GetMapping("/{id}")
    public MusicResponse getById(@PathVariable Long id) throws NotFoundException {
        return MusicMapper.toResponse(this.musicService.searchById(id));
    }

    @PutMapping("/{idMusic}")
    public MusicResponse update(@PathVariable Long idMusic, @Valid @RequestBody MusicUpdate musicUpdate) throws NotFoundException {
        return MusicMapper.toResponse(this.musicService.update(idMusic, musicUpdate));
    }

    @DeleteMapping("/{idMusic}")
    public void delete(@PathVariable Long idMusic) throws NotFoundException {
        this.musicService.remove(idMusic);
    }
}
