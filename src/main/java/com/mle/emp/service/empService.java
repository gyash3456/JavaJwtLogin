package com.mle.emp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mle.emp.dto.empDto;

public interface empService {
//	,MultipartFile file
	empDto createEmployee(empDto emp);
	
	empDto updateEmployee(empDto emp,Integer emp_id);

	
	empDto getEmployeeById(Integer emp_id);
	
	List <empDto> getAllEmps();
	
	void deleteEmployee (Integer emp_id);
}
