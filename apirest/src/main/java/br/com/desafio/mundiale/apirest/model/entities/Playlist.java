package br.com.desafio.mundiale.apirest.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Favor informar o nome.")
    private String name;

    @Size(min = 10, max = 250, message = "A descrição deve conter de 10 a 250 caracteres")
    @NotNull(message = "Informe a descrição.")
    private String description;

    private int ratingPlaylist;

    @ManyToMany
    private List<Music> musics;

    @ManyToOne
    private User user;

    public Playlist(String name, String description, int rating, List<Music> musics) {
        this.name = name;
        this.description = description;
        this.ratingPlaylist = rating;
        this.musics = new ArrayList<>();
    }

}
