package com.mle.emp.web;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mle.emp.dto.apiResponse;
import com.mle.emp.dto.empDto;
import com.mle.emp.service.empService;

@RestController
@RequestMapping("/api/auth/admin")
public class employeeController {

	@Autowired
	private empService empService;
	
	
	// POST-create user
	@PostMapping("/")
	public ResponseEntity<empDto> create_emp(@RequestBody empDto empDto1 )
	{
		empDto createdempDto=this.empService.createEmployee(empDto1);
		
		return new ResponseEntity<>(createdempDto, HttpStatus.CREATED);
	}
	
	
	
	// PUT- update user
	@PutMapping("/{emp_id}")
	public ResponseEntity<empDto> update_emp(@RequestBody empDto empDto1,@PathVariable("emp_id") Integer emp_id )
	{
		empDto updated_employee=this.empService.updateEmployee(empDto1, emp_id);
		return ResponseEntity.ok(updated_employee);
	}
	
	
//	// DELETE-delete user
	@DeleteMapping("/{empid}")
	public ResponseEntity<apiResponse> delete_user(@PathVariable  Integer empid)
	{
		this.empService.deleteEmployee(empid);
	return new ResponseEntity(new apiResponse("Employee deleted successfully",true),HttpStatus.OK);
	}
	//private void deleteEmployee(Integer empid) {
	// TODO Auto-generated method stub
	
//}



	// GET- user get,ALL User
	@GetMapping("/")
	public ResponseEntity<List<empDto>> getAllEmps()
	{
		return ResponseEntity.ok(this.empService.getAllEmps());
	}
	
	//GET single user details
	
	@GetMapping("/{emp_id}")
	public ResponseEntity<empDto> getSingleEmp(@PathVariable Integer emp_id)
	{
		return ResponseEntity.ok(this.empService.getEmployeeById(emp_id));
	}


	
	
	
	
}
