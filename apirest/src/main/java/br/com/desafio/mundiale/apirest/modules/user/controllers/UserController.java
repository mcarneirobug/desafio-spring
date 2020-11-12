package br.com.desafio.mundiale.apirest.modules.user.controllers;

import br.com.desafio.mundiale.apirest.modules.user.mappers.UserMapper;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserResponse> index() {
        return userService.searchAll();
    }

    @PostMapping("/create")
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
    public UserResponse getById(@PathVariable Long id) throws NotFoundException {
        return UserMapper.toResponse(userService.searchById(id));
    }

}
