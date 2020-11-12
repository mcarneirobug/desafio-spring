package br.com.desafio.mundiale.apirest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Favor informar o nome.")
    private String name;

    @Size(min = 10, max = 250, message = "A descrição deve conter de 10 a 250 caracteres")
    @NotNull(message = "Informe a descrição.")
    private String description;

    private int rating_playlist;

    @ManyToMany
    private List<Music> musics = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false, referencedColumnName = "id")
    private User id_user_who_created;

}
