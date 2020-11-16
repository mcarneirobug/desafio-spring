package br.com.desafio.mundiale.apirest.modules.user.controllers;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.user.mappers.UserMapper;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(value = "API REST User")
@CrossOrigin(origins = "*") // permite que qualquer domínio acesse minha API
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ApiOperation("Retorna uma lista de usuários.")
    public List<UserResponse> index() {
        return userService.searchAll();
    }

    @PostMapping("/create")
    @ApiOperation("Retorna o usuário criado.")
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    /**
     * Isso acontece com todo método que eu preciso utilizar
     * em outro lugar, fazendo a conversão para não expor
     * minha entidade do banco de dados
     *
     * @param id
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/{id}")
    @ApiOperation("Retorna o usuário específico.")
    public UserResponse getById(@PathVariable Long id) throws NotFoundException {
        return UserMapper.toResponse(userService.searchById(id));
    }

    @GetMapping("/listAllPlaylist/{idUser}")
    @ApiOperation("Retorna a lista de playlist de determinado usuário.")
    public List<PlaylistResponse> searchAllPlaylist(@PathVariable Long idUser) throws NotFoundException {
        return this.userService.searchAllPlaylist(idUser);
    }
}
