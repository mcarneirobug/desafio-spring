package br.com.desafio.mundiale.apirest.modules.music.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MusicRequest {

    @NotBlank(message = "Favor informar o nome.")
    @Size(min = 6, max = 250, message = "O nome deve conter de 6 a 250 caracteres")
    private String name;

    @NotBlank(message = "Favor informar o nome do cantor(a).")
    private String singer;

    private Integer releaseMusic;

    private Integer ratingMusic;
}
