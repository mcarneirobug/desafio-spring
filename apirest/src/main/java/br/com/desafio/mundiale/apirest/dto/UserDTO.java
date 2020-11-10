package br.com.desafio.mundiale.apirest.dto;

import br.com.desafio.mundiale.apirest.model.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    public User convertToObject() {
        return new User(name, email);
    }

}
