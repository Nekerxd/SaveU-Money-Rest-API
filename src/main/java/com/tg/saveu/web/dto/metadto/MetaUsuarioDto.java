package com.tg.saveu.web.dto.metadto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaUsuarioDto {

    @NotNull
    private Long idUsuario;
}
