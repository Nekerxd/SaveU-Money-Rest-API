package com.tg.saveu.web.dto.mapper;

import com.tg.saveu.entity.Movimentacao;
import com.tg.saveu.web.dto.movimentacaoDto.MovimentacaoDto;
import com.tg.saveu.web.dto.movimentacaoDto.MovimentacaoResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class MovimentacaoMapper {

    public static Movimentacao toMovimentacao(MovimentacaoDto createDto) {
        return new ModelMapper().map(createDto, Movimentacao.class);
    }

    public static MovimentacaoResponseDto toDto(Movimentacao movimentacao) {
        String type = movimentacao.getType().name().substring("TYPE_".length());
        String category = movimentacao.getCategory().name().split("_", 3)[2];
        String status = movimentacao.getStatus().name().split("_", 3)[2];
        PropertyMap<Movimentacao, MovimentacaoResponseDto> props = new PropertyMap<Movimentacao, MovimentacaoResponseDto>() {
            @Override
            protected void configure() {
                map().setType(type);
                map().setCategory(category);
                map().setStatus(status);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(movimentacao, MovimentacaoResponseDto.class);
    }

    public static List<MovimentacaoResponseDto> toListDto(List<Movimentacao> movimentacao) {
        return movimentacao.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
