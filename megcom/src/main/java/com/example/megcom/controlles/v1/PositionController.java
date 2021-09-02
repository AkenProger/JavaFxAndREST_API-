package com.example.megcom.controlles.v1;

import com.example.megcom.controlles.BaseCRUDController;
import com.example.megcom.models.dto.PositionDto;
import com.example.megcom.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/position")
public class PositionController implements BaseCRUDController<PositionDto, Long> {
    @Autowired
    private PositionService positionService;

    @Override
    public PositionDto save(PositionDto positionDto) {
        return positionService.save(positionDto);
    }

    @Override
    public PositionDto update(PositionDto positionDto) {
        return positionService.update(positionDto);
    }

    @Override
    public List<PositionDto> findAll() {
        return positionService.findAll();
    }

    @Override
    public PositionDto findById(Long id) {
        return positionService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        positionService.deleteById(id);
    }

}
