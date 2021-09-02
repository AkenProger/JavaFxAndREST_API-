package com.example.megcom.mappers.impl;

import com.example.megcom.mappers.PositionMapper;
import com.example.megcom.models.Position;
import com.example.megcom.models.dto.PositionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionMapperImpl implements PositionMapper {

    @Override
    public PositionDto toDto(Position position) {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(position.getId());
        positionDto.setName(position.getName());
        positionDto.setActive(position.isActive());
        return positionDto;
    }

    @Override
    public Position toEntity(PositionDto positionDto) {
        Position position = new Position();
        position.setId(positionDto.getId());
        position.setName(positionDto.getName());
        position.setActive(positionDto.isActive());
        return position;

    }

    @Override
    public List<PositionDto> toDtos(List<Position> entities) {
        return entities.stream()
                .map(s-> toDto(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<Position> toEntities(List<PositionDto> dtos) {
        return dtos.stream()
                .map(s->toEntity(s))
                .collect(Collectors.toList());
    }

}
