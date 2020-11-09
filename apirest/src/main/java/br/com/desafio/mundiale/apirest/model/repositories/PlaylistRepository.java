package br.com.desafio.mundiale.apirest.model.repositories;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
