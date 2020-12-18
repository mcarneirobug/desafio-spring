package br.com.desafio.mundiale.apirest.modules.user.services.impl;

import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.model.repositories.UserRepository;
import br.com.desafio.mundiale.apirest.modules.playlist.mappers.PlaylistMapper;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.user.mappers.UserMapper;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import br.com.desafio.mundiale.apirest.modules.user.update.UserUpdate;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        final var user = this.userRepository.save(UserMapper.to(userRequest));
        return UserMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> searchAll() {
        return this.userRepository.findAll().stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public User searchById(Long id) throws NotFoundException {
        return this.userRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhum usuário com o id informado."));
    }

    @Override
    public List<PlaylistResponse> searchAllPlaylist(Long idUser) throws NotFoundException {
        final var user = searchById(idUser);

        return user.getPlaylists()
                .stream()
                .map(PlaylistMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse update(Long idUser, UserUpdate userUpdate) throws NotFoundException {
        final var user = this.searchById(idUser);

        user.setName(userUpdate.getName());
        user.setEmail(userUpdate.getEmail());

        return UserMapper.toResponse(this.userRepository.save(user));
    }
}
