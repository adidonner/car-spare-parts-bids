package app.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Company;
import app.core.repositories.CompanyRepo;

@RestController
public class ControllerCompany {
	
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

}