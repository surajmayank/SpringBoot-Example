package com.example.TestRestApi.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.TestRestApi.model.Student;
import com.example.TestRestApi.service.StudentService;
import com.example.TestRestApi.service.StudentServiceImpl;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	StudentService si ;

	@GetMapping("student")
	public ResponseEntity<List<Student>> findStudent() {
		return new ResponseEntity<>(si.findAll(), HttpStatus.OK);
		
	}

	@GetMapping("studentByName/{name}")
	public ResponseEntity<Student> findStudentByName(@PathVariable String name) {
		Student st = si.findByName(name);
		return new ResponseEntity<>(st, HttpStatus.OK);
	}

	@PostMapping("postStudent")
	public ResponseEntity<Object> postDetails(@Valid @RequestBody Student student) {
		si.postStudentDetails(student);
		return  new ResponseEntity<>("inserted successsfully", HttpStatus.OK);
	}
	
	@PutMapping("updateStudent")
	public ResponseEntity<Object> updateDetails(@RequestParam(required=false) String name,
            @RequestParam(required = false) int id) {
		si.updateStudentDetails(name, id);
		return new ResponseEntity<>("updated successsfully", HttpStatus.OK);
	}

}
