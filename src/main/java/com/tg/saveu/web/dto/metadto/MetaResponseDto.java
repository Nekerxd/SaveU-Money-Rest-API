package com.tg.saveu.web.dto.metadto;

import com.tg.saveu.entity.Meta;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MetaResponseDto {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private Float goal;
    private Float progress;
    private String role;
}
