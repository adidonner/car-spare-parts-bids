package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.exceptions.CompaniesException;
import app.core.exceptions.CustomersException;
import app.core.repositories.CompanyRepo;
import app.core.repositories.CustomerRepo;

/**
 * @author adido
 *
 */
@Service
@Transactional
public class AdminService extends ClientService {

	@Value("${admin.email}")
	private String adminEmail;
	@Value("${admin.password}")
	private String adminPassword;
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private CustomerRepo customerRepo;

	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Company addCompany(Company company) throws CompaniesException {
		if (!this.companyRepo.existsByName(company.getName())) {
			this.companyRepo.save(company);
			return company;
		} else {
			throw new CompaniesException(
					"addCompany failed - a company with this name already exists: " + company.getName());
		}
	}
	// email must be unique
		public Customer addCustomer(Customer customer) throws CustomersException {
			if (!this.customerRepo.existsByEmail(customer.getEmail())) {
				this.customerRepo.save(customer);;
				return customer;
			} else {
				throw new CustomersException("addCustamer failed - a custmer with this email already exists: "
						+ customer.getFirstName() + " " + customer.getLastName());
			}
		}
}
