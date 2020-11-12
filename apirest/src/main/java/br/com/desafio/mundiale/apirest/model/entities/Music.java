package br.com.desafio.mundiale.apirest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Favor informar o nome.")
    @Size(min = 6, max = 250, message = "O nome deve conter de 6 a 250 caracteres")
    private String name;

    @NotBlank(message = "Favor informar o nome do cantor(a).")
    private String singer;

    private Integer releaseMusic;

    private Integer ratingMusic;

}
