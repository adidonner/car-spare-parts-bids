package app.core.web.fallbacks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbacksController {

	@GetMapping("/fallback/serviceAdmin") // copy path from gateway yaml at GITHUB
	public String fallbackAdmin() {
		return "Gateway Fallback: can't call service-admin" ;
	}
	
	@GetMapping("/fallback/serviceCompany") // copy path from gateway yaml at GITHUB
	public String fallbackCompany() {
		return "Gateway Fallback: can't call service-company";
	}
}
