package br.com.desafio.mundiale.apirest.model.repositories;

import br.com.desafio.mundiale.apirest.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
