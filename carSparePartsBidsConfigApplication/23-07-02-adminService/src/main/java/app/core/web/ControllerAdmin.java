package app.core.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.services.AdminService;

//@RequestMapping("api/admin")
@RestController
public class ControllerAdmin{

	@Autowired
	private RestTemplate rt;
	
	@Autowired
	private AdminService adminService;
	
	// http://localhost:8001/service/admin
	@HystrixCommand(fallbackMethod = "handleAdminFallback", commandKey = "ControllerAdmin.handleAdmin")
	@GetMapping("/service/admin")
	public String handleAdmin() {
		String url = "http://service-company/service/company";
		String responseOfServiceCompany = rt.getForObject(url, String.class);
		return "service admin: " + responseOfServiceCompany;
	}
	@GetMapping("/service/admin1")
	public String getCompanyDetails() {
		String url = "http://service-company/service/company-details";
		String responseOfServiceCompany = rt.getForObject(url, String.class);
		return "service admin: " + responseOfServiceCompany;
	}

	public String handleAdminFallback(Throwable t) {
		return "service admin fallback: can't reach service company. cause: " + t;
	}
	
	@GetMapping("/all-companies")
	public List<Company> getAllCompanies() {
		return this.adminService.getAllCompanies();
	}
	@GetMapping("/all-customers")
	public List<Customer> getAllCustomers() {
		return this.adminService.getAllCustomers();
	}
	@GetMapping("/get-company-id/{companyId}")
	public Company getCompanyById(@PathVariable int companyId) {
			return this.adminService.getCompanyById(companyId);
	}
}
