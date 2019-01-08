package com.mytech.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytech.employee.model.DepartmentDto;
import com.mytech.employee.service.DeptService;


@RestController
public class DepartmentController {

	@Autowired
	DeptService deptService;

	@RequestMapping(value = "/org/dept/", method = RequestMethod.GET)
	ResponseEntity<List<DepartmentDto>> getDept() {

		return ResponseEntity.ok(deptService.getAllDepts());
	}

}
