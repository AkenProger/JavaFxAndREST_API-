package com.example.megcom.mappers.impl;

import com.example.megcom.mappers.DepartmentMapper;
import com.example.megcom.models.Department;
import com.example.megcom.models.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public DepartmentDto toDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setActive(department.isActive());
        return departmentDto;
    }


    @Override
    public Department toEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setActive(departmentDto.isActive());
        return department;
    }

    @Override
    public List<DepartmentDto> toDtos(List<Department> entities) {
        return entities.stream()
                .map(s-> toDto(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<Department> toEntities(List<DepartmentDto> dtos) {
        return dtos.stream()
                .map(s->toEntity(s))
                .collect(Collectors.toList());
    }
}
