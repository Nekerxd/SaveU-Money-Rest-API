package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaDto {

    @NotNull
    private Usuario usuario;
    @NotBlank
    @Size(max = 150)
    private String description;
    private LocalDate dueDate;
    @NotNull
    private Float goal;
    @NotBlank
    private String role;
}
