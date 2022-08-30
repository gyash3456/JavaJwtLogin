package com.mle.emp.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mle.emp.dto.apiResponse;
import com.mle.emp.dto.empDto;
import com.mle.emp.service.empService;

@RestController
@RequestMapping("/api/auth/admin")
public class employeeController {

	@Autowired
	private empService empService;
	
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/static/imgdata";
	// POST-create user
	@PostMapping("/")
//	@RequestParam("finename") MultipartFile file
	public ResponseEntity<empDto> create_emp(@RequestBody empDto empDto1)
	{
//		StringBuilder fileName = new StringBuilder();
//		String filename1= file.getOriginalFilename();
//		Path fileNameAndPath=Paths.get(uploadDirectory,filename1);
//		try {
//			Files.write(fileNameAndPath,file.getBytes());
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		,file
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
