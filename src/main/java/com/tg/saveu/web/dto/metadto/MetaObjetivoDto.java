package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaObjetivoDto {

    @NotNull
    private Usuario usuario;
    @NotNull
    private Float novoObjetivo;
}
