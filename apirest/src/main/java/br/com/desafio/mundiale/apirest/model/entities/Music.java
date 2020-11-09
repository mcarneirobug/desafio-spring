package br.com.desafio.mundiale.apirest.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Favor informar o nome.")
    @Size(min = 6, max = 250, message = "O nome deve conter de 6 a 250 caracteres")
    private String name;

    @NotBlank(message = "Favor informar o nome do cantor(a).")
    private String singer;

    private int releaseMusic;

    private int ratingMusic;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "musics")
    private List<Playlist> playlist = new ArrayList<>();

    public Music(String name, String singer, int release, int rating) {
        this.name = name;
        this.singer = singer;
        this.releaseMusic = release;
        this.ratingMusic = rating;
    }

}
