package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.Meta;
import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaUpdateDto {

    @NotNull
    private Usuario usuario;
    @NotNull
    private Meta.Role role;
    @NotBlank
    @Size(max = 150)
    private String novaDescricao;
    @NotNull
    private Float novoObjetivo;
    @NotNull
    private LocalDate novoPrazo;
}
