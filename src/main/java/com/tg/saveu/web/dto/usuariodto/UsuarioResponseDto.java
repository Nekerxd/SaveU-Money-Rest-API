package com.tg.saveu.web.dto.usuariodto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioResponseDto {

    private Long id;
    private String email;
    private String name;
    private String role;
}
