package com.mle.Demo.service;

import java.util.List;

import com.mle.Demo.dto.empDto;

public interface empService {
	
	empDto createEmployee(empDto emp);
	
	empDto updateEmployee(empDto emp,Integer emp_id);

	
	empDto getEmployeeById(Integer emp_id);
	
	List <empDto> getAllEmps();
	
	void deleteEmployee (Integer emp_id);
}
