package in.cg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cg.demo.model.Employee;
@Repository
public interface EmployeeRepos extends JpaRepository<Employee, Integer> {

}
