package com.tg.saveu.web.dto.metadto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaPrazoDto {

    @NotNull
    private Long idUsuario;
    private LocalDate novoPrazo;
}
