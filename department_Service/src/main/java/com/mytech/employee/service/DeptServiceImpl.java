package com.mytech.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.employee.dao.repository.DepartmentRepository;
import com.mytech.employee.model.DepartmentDto;


@Service
public class DeptServiceImpl implements DeptService {
	
	
	@Autowired DepartmentRepository departmentRepository;

	@Override
	public List<DepartmentDto> getAllDepts() {

		List<DepartmentDto> departmentDtoList = new ArrayList<DepartmentDto>();
		departmentRepository.findAll()
				.forEach(d -> departmentDtoList.add(new DepartmentDto(d.getNumber(), d.getName(), d.getLocation())));

		return departmentDtoList;
	}

}
