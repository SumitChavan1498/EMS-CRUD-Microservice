package in.cg.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cg.demo.model.Employee;
import in.cg.demo.repository.EmployeeRepos;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({"/api"})
@RestController
public class EmployeeController {

		@Autowired
		private EmployeeRepos repos;
		
		@GetMapping(path="/employee")
		public List<Employee> retrieveAllEmployee(){
	        System.out.println("inside retrieveAllEmployee of Controller" );
	        return  repos.findAll();
	    }
		
		@PostMapping(path="/add")
		public Employee add(@Valid @RequestBody Employee emp) {
	        System.out.println("inside add() of Controller" );
	       if(emp.getDob().before(emp.getDoj())) {
	        return repos.save(emp);
	       }
	       else 
	    	   return null;
		}
		
		@GetMapping(path="/findById/{id}")
		public Optional<Employee> findById(@PathVariable int id) {
			 System.out.println("inside findById of Controller" );
			 return repos.findById(id);
		}
		
		@GetMapping(path="/delete/{id}")
		public List<Employee> delete(@PathVariable int id) {
			 System.out.println("inside delete of Controller" );
			  repos.deleteById(id);
			  return repos.findAll();
		}
		

		
		@PutMapping(path="/updateEmployee/{empId}")
		public Employee editEmployeeDetails(@Valid @PathVariable int empId,@RequestBody Employee employee) {
			System.out.println(empId);
			//repos.findById(empId);
		Employee emp = 	repos.save(employee);
			return emp;
		}
		
		@DeleteMapping(path="/deleteAll")
		public void deleteAllDetails() {
			
			repos.deleteAll();
		}
}
	
		

