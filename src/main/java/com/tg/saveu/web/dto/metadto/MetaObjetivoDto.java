package com.tg.saveu.web.dto.metadto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaObjetivoDto {

    @NotNull
    private Long idUsuario;
    @NotNull
    private Float novoObjetivo;
}
