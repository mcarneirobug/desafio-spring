package br.com.desafio.mundiale.apirest.modules.music.controllers;

import br.com.desafio.mundiale.apirest.modules.music.mappers.MusicMapper;
import br.com.desafio.mundiale.apirest.modules.music.request.MusicRequest;
import br.com.desafio.mundiale.apirest.modules.music.response.MusicResponse;
import br.com.desafio.mundiale.apirest.modules.music.services.MusicService;
import br.com.desafio.mundiale.apirest.modules.music.update.MusicUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/music")
@Api("API REST Music")
@CrossOrigin(value = "*")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/create")
    @ApiOperation("Crie uma nova música.")
    public MusicResponse create(@RequestBody @Valid MusicRequest musicRequest) {
        return this.musicService.create(musicRequest);
    }

    @GetMapping("/list")
    @ApiOperation("Visualize uma lista de músicas.")
    public List<MusicResponse> index() {
        return this.musicService.searchAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Visualize uma música.")
    public MusicResponse getById(@PathVariable Long id) throws NotFoundException {
        return MusicMapper.toResponse(this.musicService.searchById(id));
    }

    @PutMapping("/{idMusic}")
    @ApiOperation("Atualize uma música.")
    public MusicResponse update(@PathVariable Long idMusic, @Valid @RequestBody MusicUpdate musicUpdate) throws NotFoundException {
        return MusicMapper.toResponse(this.musicService.update(idMusic, musicUpdate));
    }
}
