package br.com.desafio.mundiale.apirest.controllers;

import br.com.desafio.mundiale.apirest.dto.UserDTO;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.model.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> index() {
        return userService.searchAll();
    }

    @PostMapping("/create")
    public ResponseEntity<User> addUserDTO(@Valid @RequestBody UserDTO dto) {
        User user = userService.create(dto.convertToObject());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) throws NotFoundException {
        return userService.searchById(id);
    }

    @GetMapping
    public User getByIdParam(@RequestParam(name = "id") Long id) throws NotFoundException {
        return userService.searchById(id);
    }

//    @GetMapping("/list/playlists")
//    public List<Playlist> listPlaylist(@RequestParam(name = "id") Long id) throws NotFoundException {
//        return userService.searchAllPlaylist(id);
//    }

//    @GetMapping("/list/musics")
//    public List<Music> listMusic(@RequestParam(name = "id") Long id) throws NotFoundException {
//        return userService.searchAllMusic(id);
//    }

}
