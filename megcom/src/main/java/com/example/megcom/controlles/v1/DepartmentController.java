package com.example.megcom.controlles.v1;

import com.example.megcom.controlles.BaseCRUDController;
import com.example.megcom.models.dto.DepartmentDto;
import com.example.megcom.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/department")
public class DepartmentController implements BaseCRUDController<DepartmentDto, Long> {
    @Autowired
    DepartmentService departmentService;

    @Override
    public DepartmentDto save(DepartmentDto S) {
        return departmentService.save(S);
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto) {
        return departmentService.update(departmentDto);
    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentService.findAll();
    }

    @Override
    public DepartmentDto findById(Long id) {
        return departmentService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        departmentService.deleteById(id);
    }
}
