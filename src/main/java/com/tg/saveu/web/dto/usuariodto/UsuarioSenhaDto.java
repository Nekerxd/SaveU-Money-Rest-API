package com.tg.saveu.web.dto.usuariodto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioSenhaDto {

    @NotBlank
    @Size(min = 8, max = 32)
    private String senhaAtual;
    @NotBlank
    @Size(min = 8, max = 32)
    private String novaSenha;
    @NotBlank
    @Size(min = 8, max = 32)
    private String confirmaSenha;
}