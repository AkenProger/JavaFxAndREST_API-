package com.example.megcom.services.impl;

import com.example.megcom.dao.PositionRepo;
import com.example.megcom.mappers.PositionMapper;
import com.example.megcom.models.Position;
import com.example.megcom.models.dto.PositionDto;
import com.example.megcom.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private PositionMapper positionMapper;


    @Override
    public PositionDto save(PositionDto positionDto) {
        Position position = positionMapper.toEntity(positionDto);
        position = positionRepo.save(position);
        return positionMapper.toDto(position);
    }

    @Override
    public PositionDto update(PositionDto positionDto) {
        if (!positionRepo.existsById(positionDto.getId()))
            throw new RuntimeException("Позиция не найдена!");

        Position position = positionMapper.toEntity(positionDto);
        position = positionRepo.save(position);
        return positionMapper.toDto(position);
    }

    @Override
    public List<PositionDto> findAll() {
        return positionMapper.toDtos(positionRepo.findAll());
    }

    @Override
    public PositionDto findById(Long id) {
        Position position = positionRepo.findById(id).orElseThrow(() -> new RuntimeException("Позиция не найдена!"));
        return positionMapper.toDto(position);
    }

    @Override
    public void deleteById(Long id) {
        positionRepo.deleteById(id);
    }
}
