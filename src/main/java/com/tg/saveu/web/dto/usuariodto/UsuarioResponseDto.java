package com.tg.saveu.web.dto.usuariodto;

import com.tg.saveu.entity.Conta;
import com.tg.saveu.web.dto.metadto.MetaResponseDto;
import lombok.*;

import java.util.Collection;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioResponseDto {

    private Long id;
    private String email;
    private String name;
    private String role;
    private Collection<MetaResponseDto> metas;
    private Collection<Conta> contas;
}
