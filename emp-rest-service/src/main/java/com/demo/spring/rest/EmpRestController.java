package com.demo.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.Message;
import com.demo.spring.entity.Emp;
import com.demo.spring.entity.MyList;

@RestController
@CrossOrigin()
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	@GetMapping(path = "/emp/find/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity findEmp(@PathVariable("id") int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			throw new RuntimeException("Emp Not Found");
		}
	}

	@GetMapping(path = "/emp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MyList> getList() {
		List<Emp> empList = repo.findAll();
		MyList mylist = new MyList();
		mylist.setEmpList(empList);
		return ResponseEntity.ok(mylist);
	}

	@PostMapping(path = "/emp/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveEmp(@RequestBody Emp e) {
		if (repo.existsById(e.getEmpId())) {
			Message message = new Message();
			message.setStatus("Employee Exists");
			return ResponseEntity.ok(message);
		} else {
			repo.save(e);
			Message message = new Message();
			message.setStatus("Employee saved");
			return ResponseEntity.ok(message);
		}
	}

	@PutMapping(path = "/emp/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateEmp(@RequestBody Emp e) {
		repo.save(e);
		Message message = new Message();
		message.setStatus("Employee Updated");
		return ResponseEntity.ok(message);
	}

	@DeleteMapping(path = "/emp/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> delete(@RequestParam("id")int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			Message message = new Message();
			message.setStatus("Employee Deleted");
			return ResponseEntity.ok(message);
		} else {
			Message message = new Message();
			message.setStatus("Employee Not Found");
			return ResponseEntity.ok(message);
		}
	}
	
	
	@GetMapping(path = "/emp/list", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MyList> getList1(@RequestParam("city")String city) {
		/*
		 * Emp e= new Emp(); e.setCity(city); Example<Emp> example=Example.of(e);
		 * List<Emp> empList = repo.findAll(example);
		 */
		List<Emp> empList=repo.findAllInCity(city);
		MyList mylist = new MyList();
		mylist.setEmpList(empList);
		return ResponseEntity.ok(mylist);
	}
	/*
	 * @ExceptionHandler(RuntimeException.class) public ResponseEntity
	 * handleEmpNotFound(RuntimeException ex) { return
	 * ResponseEntity.ok("Emp Not Found with the Given Id"); }
	 */
	@GetMapping(path = "/emp/list1", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Emp>> getList1() {
		List<Emp> empList = repo.findAll();
		
		return ResponseEntity.ok(empList);
	}
}
