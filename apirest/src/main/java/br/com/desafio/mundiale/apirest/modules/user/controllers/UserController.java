package br.com.desafio.mundiale.apirest.modules.user.controllers;

import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.user.mappers.UserMapper;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import br.com.desafio.mundiale.apirest.modules.user.update.UserUpdate;
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

    @PostMapping("/create")
    @ApiOperation("Crie um novo usuário.")
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/list")
    @ApiOperation("Visualize uma lista de usuários")
    public List<UserResponse> index() {
        return userService.searchAll();
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
    @ApiOperation("Visualize um usuário.")
    public UserResponse getById(@PathVariable Long id) throws NotFoundException {
        return UserMapper.toResponse(userService.searchById(id));
    }

    @PutMapping("/{idUser}")
    @ApiOperation("Atualize um usuário.")
    public UserResponse update(@PathVariable Long idUser, @Valid @RequestBody UserUpdate userUpdate) throws NotFoundException {
        return UserMapper.toResponse(userService.update(idUser, userUpdate));
    }

    @GetMapping("/listAllPlaylist/{idUser}")
    @ApiOperation("Visualize todas as playlists de um usuário.")
    public List<PlaylistResponse> searchAllPlaylist(@PathVariable Long idUser) throws NotFoundException {
        return this.userService.searchAllPlaylist(idUser);
    }
}
