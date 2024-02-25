package com.tg.saveu.web.dto.mapper;

import com.tg.saveu.entity.Meta;
import com.tg.saveu.web.dto.metadto.MetaCreateDto;
import com.tg.saveu.web.dto.metadto.MetaResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class MetaMapper {

    public static Meta toMeta(MetaCreateDto createDto) {
        return new ModelMapper().map(createDto, Meta.class);
    }

    public static MetaResponseDto toDto(Meta meta) {
        String role = meta.getRole().name().substring("ROLE_".length());
        PropertyMap<Meta, MetaResponseDto> props = new PropertyMap<Meta, MetaResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(meta, MetaResponseDto.class);
    }


    public static List<MetaResponseDto> toListDto(List<Meta> metas) {
        return metas.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
