package com.mle.Demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.mle.Demo.domain.Employee;
import com.mle.Demo.dto.empDto;
import com.mle.Demo.exception.*;
import com.mle.Demo.repository.empRepo;
import com.mle.Demo.service.empService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import net.bytebuddy.asm.Advice.This;

@Service
public class empServiceImpl implements empService {
	
	@Autowired
     private empRepo empRepo ;
     
	@Override
	public empDto createEmployee(empDto empDto1)
	{   String user_id=empDto1.getEmail();
	Employee savedEmployee;
	//System.out.println(user_id);
		Employee employee=this.dtoToEmployee(empDto1);
		//Boolean x=false;
		
		 Optional<Employee> emp=this.empRepo.findByEmail(user_id);
//		 System.out.println(emp);
		if(emp.isPresent()) {
			throw(new ResourceAlreadyPresentException("Employee",user_id));
			
		}
		else {
			savedEmployee =this.empRepo.save(employee);
		}
		
		return employeetoDto(savedEmployee);
		
		
	}
	
	
 

	@Override
	public empDto updateEmployee(empDto empDto1, Integer emp_id) {
	 Employee emp=this.empRepo.findById(emp_id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",emp_id));
	    emp.setPassword(empDto1.getPassword());
	    emp.setFirstName(empDto1.getFirstName());
		emp.setLastName(empDto1.getLastName());
	    emp.setPassword(empDto1.getPassword());
	    emp.setEmail(empDto1.getEmail());
	    emp.setGender(empDto1.getGender());
	    emp.setDate_of_birth(empDto1.getDate_of_birth());
	    emp.setMobile(empDto1.getMobile());
	    emp.setAadhar(empDto1.getAadhar());
	    emp.setPan_no(empDto1.getPan_no());
	    emp.setAddress(empDto1.getAddress());
	    emp.setJoning_date(empDto1.getJoining_date());
	    emp.setAccount_no(empDto1.getAccount_no());
	    emp.setIfsc_code(empDto1.getIfsc_code());
	    emp.setBank_name(empDto1.getBank_name());
	    emp.setDesignation(empDto1.getDesignation());
	    emp.setBlood_group(empDto1.getBlood_group());
	 Employee updatedEmployee=this.empRepo.save(emp);
	 
	 empDto empDto2=this.employeetoDto(updatedEmployee);
		return empDto2;
	}

	@Override
	public empDto getEmployeeById(Integer emp_id) {
		Employee emp=this.empRepo.findById(emp_id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",emp_id));
		return this.employeetoDto(emp);
	}

	@Override
	public List<empDto> getAllEmps() {
		List<Employee> employee=this.empRepo.findAll();
		List<empDto> empDto1=employee.stream().map(employee1->this.employeetoDto(employee1)).collect(Collectors.toList());
		return empDto1;
	}

	@Override
	public void deleteEmployee(Integer emp_id) {
		Employee emp=this.empRepo.findById(emp_id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",emp_id));
		this.empRepo.delete(emp);

	}
	
	public Employee dtoToEmployee (empDto empDto1)
	{
		Employee emp  =new Employee();
		emp.setEmp_id(empDto1.getEmp_id());
		emp.setFirstName(empDto1.getFirstName());
		emp.setLastName(empDto1.getLastName());
	    emp.setPassword(empDto1.getPassword());
	    emp.setEmail(empDto1.getEmail());
	    emp.setGender(empDto1.getGender());
	    emp.setDate_of_birth(empDto1.getDate_of_birth());
	    emp.setMobile(empDto1.getMobile());
	    emp.setAadhar(empDto1.getAadhar());
	    emp.setPan_no(empDto1.getPan_no());
	    emp.setAddress(empDto1.getAddress());
	    emp.setJoning_date(empDto1.getJoining_date());
	    emp.setAccount_no(empDto1.getAccount_no());
	    emp.setIfsc_code(empDto1.getIfsc_code());
	    emp.setBank_name(empDto1.getBank_name());
	    emp.setDesignation(empDto1.getDesignation());
	    emp.setBlood_group(empDto1.getBlood_group());
	    return emp;
	}
	
	public empDto employeetoDto (Employee emp)
	{
		empDto empDto1 =new empDto();
		empDto1.setEmp_id(emp.getEmp_id());		
	    empDto1.setPassword(emp.getPassword());
	    empDto1.setFirstName(emp.getFirstName());
		empDto1.setLastName(emp.getLastName());
	    
	    empDto1.setEmail(emp.getEmail());
	    empDto1.setGender(emp.getGender());
	    empDto1.setDate_of_birth(emp.getDate_of_birth());
	    empDto1.setMobile(emp.getMobile());
	    empDto1.setAadhar(emp.getAadhar());
	    empDto1.setPan_no(emp.getPan_no());
	    empDto1.setAddress(emp.getAddress());
	    empDto1.setJoining_date(emp.getJoining_date());
	    empDto1.setAccount_no(emp.getAccount_no());
	    empDto1.setIfsc_code(emp.getIfsc_code());
	    empDto1.setBank_name(emp.getBank_name());
	    empDto1.setDesignation(emp.getDesignation());
	    empDto1.setBlood_group(emp.getBlood_group());
		return empDto1;
	}

}
