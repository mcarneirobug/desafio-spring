package br.com.desafio.mundiale.apirest.modules.user.services.impl;

import br.com.desafio.mundiale.apirest.model.entities.User;
import br.com.desafio.mundiale.apirest.model.repositories.UserRepository;
import br.com.desafio.mundiale.apirest.modules.user.mappers.UserMapper;
import br.com.desafio.mundiale.apirest.modules.user.request.UserRequest;
import br.com.desafio.mundiale.apirest.modules.user.response.UserResponse;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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


}
