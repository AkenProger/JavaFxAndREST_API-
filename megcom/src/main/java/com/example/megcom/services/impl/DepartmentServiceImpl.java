package com.example.megcom.services.impl;

import com.example.megcom.dao.DepartmentRepo;
import com.example.megcom.mappers.DepartmentMapper;
import com.example.megcom.models.Department;
import com.example.megcom.models.Position;
import com.example.megcom.models.dto.DepartmentDto;
import com.example.megcom.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = departmentMapper.toEntity(departmentDto);
        department = departmentRepo.save(department);
        return departmentMapper.toDto(department);
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto) {
        if (departmentRepo.existsById(departmentDto.getId()))
            throw new RuntimeException("Департамент не найден!");
        Department department = departmentMapper.toEntity(departmentDto);
        department = departmentRepo.save(department);
        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentMapper.toDtos(departmentRepo.findAll());
    }

    @Override
    public DepartmentDto findById(Long id) {
        Department department = departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Департамент не найден!"));
        return departmentMapper.toDto(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepo.deleteById(id);
    }
}
