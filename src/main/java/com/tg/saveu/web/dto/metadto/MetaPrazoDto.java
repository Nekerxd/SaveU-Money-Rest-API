package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaPrazoDto {

    @NotNull
    private Usuario usuario;
    private LocalDate novoPrazo;
}
