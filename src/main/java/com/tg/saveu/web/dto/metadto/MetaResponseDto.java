package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.CategoryEnum;
import com.tg.saveu.entity.Meta;
import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaResponseDto {

    private Long id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Float goal;
    private Meta.Role role;
    private CategoryEnum category;
}
