package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.services.AdminService;

@Component
@Order(1)
public class RegistrationDemo implements CommandLineRunner {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n\t\t\t\t==================================== ");
		System.out.println("\t\t\t\t============ REGISTRATION DEMO ============ ");
		System.out.println("\t\t\t\t==================================== ");

		System.out.println("\n========== ADMIN CREATE COMPANIES ==========");
		Company company1 = ctx.getBean(Company.class);
		company1.setName("David Repairs");
		company1.setEmail("david@mail");
		company1.setPassword("davi");
		company1.setLogoImage("https://illustoon.com/photo/dl/9482.png");
		adminService.addCompany(company1);

		Company company2 = ctx.getBean(Company.class);
		company2.setName("Moshe Repairs");
		company2.setEmail("moshe@mail");
		company2.setPassword("mosh");
		company2.setLogoImage("https://illustoon.com/photo/dl/9481.png");
		adminService.addCompany(company2);

		Company company3 = ctx.getBean(Company.class);
		company3.setName("Rami");
		company3.setEmail("rami@mail");
		company3.setPassword("rami");
		company3.setLogoImage("https://illustoon.com/photo/dl/9483.png");
		adminService.addCompany(company3);
		System.out.println(company1);
		System.out.println(company2);
		System.out.println(company3);

		System.out.println("\n==========ADMIN CREATE CUSTOMERS ==========");
		Customer customer1 = ctx.getBean(Customer.class);
		customer1.setFirstName("Dina");
		customer1.setLastName("Levi");
		customer1.setEmail("dina@gmail.com");
		customer1.setPassword("dina");
		customer1.setUserName("Din Din");
		adminService.addCustomer(customer1);

		Customer customer2 = ctx.getBean(Customer.class);
		customer2.setFirstName("Dan");
		customer2.setLastName("Ramon");
		customer2.setUserName("Darmon");
		customer2.setEmail("ramon@mail");
		customer2.setPassword("ramo");
		adminService.addCustomer(customer2);

		Customer customer3 = ctx.getBean(Customer.class);
		customer3.setFirstName("Richard");
		customer3.setLastName("Badash");
		customer3.setUserName("Richie");
		customer3.setEmail("richard@gmail.com");
		customer3.setPassword("rich");
		adminService.addCustomer(customer3);

		System.out.println("\nRegistred Companies: ");
		System.out.println(adminService.getAllCompanies());
		System.out.println("\nRegistred Customers: ");
		System.out.println(adminService.getAllCustomers());

	}
}