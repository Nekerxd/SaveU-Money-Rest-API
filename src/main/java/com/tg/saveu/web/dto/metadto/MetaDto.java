package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.CategoryEnum;
import com.tg.saveu.entity.Meta;
import com.tg.saveu.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaDto {

    @NotNull
    private Usuario usuario;
    @NotBlank
    @Size(max = 50)
    private String title;
    @Size(max = 200)
    private String description;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private Float goal;
    @NotBlank
    private String role;
    private String category;
}
