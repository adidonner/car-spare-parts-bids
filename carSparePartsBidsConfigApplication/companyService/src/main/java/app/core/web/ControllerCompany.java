package app.core.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import app.core.entities.Company;
import app.core.repositories.CompanyRepo;

@RestController
public class ControllerCompany {
	
	@Autowired
	private RestTemplate rt;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Value("${spring.cloud.consul.discovery.instanceId}")
	private String instanceId;
	
	@GetMapping("/service/company")
	public String handleCompany() {
		return "from :" + this.instanceId;
	}
	
	@GetMapping("/service/company-details")
	public String getCompanyDetails() {
		String companyName = companyRepo.getOne(1).getName();
		return companyName + " " +this.instanceId;
	}
	@GetMapping("/company/{companyId}")
	public Company getCompanyById(@PathVariable("companyId") int companyId) {
		String url = "http://service-admin/get-company-id/{companyId}" ;
		Company company = rt.getForObject(url, Company.class, companyId);
		return company;
	}

	@GetMapping("/all-companies")
	public Company[] getAllCompanies() {
		String url = "http://service-admin/all-companies" ;
		Company[] companies = rt.getForObject(url, Company[].class);
		for (Company company : companies) {  
			companyRepo.save(company);  // Erase all other companies existed before
		}
		return companies;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/get-all-companies-from-admin")
//	public List<Company> getAllCompanies() {
//		String url = "http://localhost:8001/get-company-id/3";
////		List<Company> responseOfServiceCompany = rt.getForObject(url, List.class);
//		List<Company> responseOfServiceAdmin = rt.get;
//		
//		return  responseOfServiceAdmin;
//		return "Companies List: " + rt.getForObject(url, String.class);
//	}

}