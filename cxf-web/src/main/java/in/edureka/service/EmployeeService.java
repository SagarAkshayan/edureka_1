package in.edureka.service;

import in.edureka.model.Employee;

import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@SuppressWarnings("restriction")
@WebService
@Path("/")
@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml", "application/x-www-form-urlencoded"})
public interface EmployeeService {

	@Path("/save")
	@POST
	@WebMethod
	public boolean saveOrUpdateEmployee(Employee emp);
	
	@Path("/list")
	@GET
	@WebMethod
	public  List<Employee> getAllEmployees();
	
	@Path("/get/{id}")
	@GET
	@WebMethod
	public Employee getEmployee(@PathParam("id") int id);
	
	@Path("/delete/{id}")
	@PUT
	@WebMethod
	public boolean deleteEmployee(@PathParam("id") int id);

}
