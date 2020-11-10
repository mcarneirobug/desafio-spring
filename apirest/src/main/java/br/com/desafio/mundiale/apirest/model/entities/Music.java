package br.com.desafio.mundiale.apirest.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(catalog = "springdesafio", name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Favor informar o nome.")
    @Size(min = 6, max = 250, message = "O nome deve conter de 6 a 250 caracteres")
    private String name;

    @Column(name = "singer")
    @NotBlank(message = "Favor informar o nome do cantor(a).")
    private String singer;

    @Column(name = "release_music")
    private Integer releaseMusic;

    @Column(name = "rating_music")
    private Integer ratingMusic;

}
