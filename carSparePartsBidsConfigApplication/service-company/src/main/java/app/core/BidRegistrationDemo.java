package app.core;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import app.core.entities.Bid;
import app.core.entities.Bid.Manufacturer;
import app.core.entities.Bid.Part;
import app.core.entities.Company;
import app.core.services.CompanyService;

@Component
public class BidRegistrationDemo implements CommandLineRunner {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		Company company1 = ctx.getBean(Company.class);
		company1.setName("Osem");
		company1.setEmail("osem@mail");
		company1.setPassword("osem");
		company1.setLogoImage("https://upload.wikimedia.org/wikipedia/he/2/22/Osem_Logo.svg");
		company1.setPhoneNumber("0123456789");
		companyService.addCompany(company1);

		Bid bid1 = ctx.getBean(Bid.class);
		bid1.setAmount(5);
		bid1.setCompany(company1);
		bid1.setImage(
				"https://static.vecteezy.com/system/resources/previews/017/092/391/original/car-engine-icon-vector.jpg");
		bid1.setManufacturer(Manufacturer.FORD);
		bid1.setManufacturingDate(LocalDate.of(2020, 1, 5));
		bid1.setPart(Part.MOTOR);
		bid1.setPrice(8000);
		companyService.addBidToCompany(company1, bid1);

		System.out.println(company1);
		System.out.println(bid1);

		Bid bid2 = ctx.getBean(Bid.class);
		bid2.setAmount(16);
		bid2.setCompany(company1);
		bid2.setImage(
				"https://w7.pngwing.com/pngs/100/912/png-transparent-alloy-wheel-car-tire-car-wheel-technic-car-car-tires-thumbnail.png");
		bid2.setManufacturer(Manufacturer.TOYOTA);
		bid2.setManufacturingDate(LocalDate.of(2022, 12, 24));
		bid2.setPart(Part.WHEEL);
		bid2.setPrice(500);
		companyService.addBidToCompany(company1, bid2);

//		System.out.println(company1);
		System.out.println(bid1);
		
		System.out.println(companyService.getCompanyDetails(1));

	}
}
