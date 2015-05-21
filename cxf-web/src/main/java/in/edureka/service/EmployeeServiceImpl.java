package in.edureka.service;

import in.edureka.model.Employee;

import javax.jws.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Sagar Akshayan
 *
 */
@Service("empService")
@WebService(endpointInterface = "in.edureka.service.EmployeeService",
serviceName="empServiceWSDL")
public class EmployeeServiceImpl implements EmployeeService {

	Map<Integer,Employee> employee = new HashMap<Integer,Employee>();
	
	public boolean saveOrUpdateEmployee(Employee emp){
	    employee.put(emp.getId(),emp);
		return true;
	}
	
	public List<Employee> getAllEmployees(){
		 return new ArrayList<Employee>(employee.values());
	}
	
	public Employee getEmployee(int id){
		if(employee.get(id) != null) return employee.get(id);
		else return new Employee();
	}
	
	public Employee getEmployeeByAgeName(int age,String name){
	  Iterator<Entry<Integer,Employee>> iterator=employee.entrySet().iterator();
	  while(iterator.hasNext()){
		  Entry<Integer,Employee> empEntry=iterator.next();
		  Employee emp=empEntry.getValue();
		  if(emp.getAge() == age && emp.getName().equals(name)){
			  return emp;
		  }
	  }
	  return new Employee();
	}
	public boolean deleteEmployee(int id){
		if(employee.get(id) != null){
		  employee.remove(id);
		  return true;
		}
		return false;
	}
	
}
