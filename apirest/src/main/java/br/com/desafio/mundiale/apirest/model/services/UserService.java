package br.com.desafio.mundiale.apirest.model.services;

import br.com.desafio.mundiale.apirest.model.entities.Music;
import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.model.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User objUser) {
        return this.userRepository.save(objUser);
    }

    public List<User> searchAll() {
        return this.userRepository.findAll();
    }

    public User searchById(Long id) throws NotFoundException {
        return this.userRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhum usuário com o id informado."));
    }

    public List<Music> searchAllMusic(Long id) throws NotFoundException {
        final var user = this.searchById(id);
        return user.getMusics();
    }




}
