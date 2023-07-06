package app.core.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"customers"} )
@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Enumerated(EnumType.STRING)
	private Manufacturer manufacturer;
	@Enumerated(EnumType.STRING)
	private Part part;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate manufacturingDate;
	
	private int amount;
	private double price;
	private String image;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(

			name = "customer_bid",

			joinColumns = @JoinColumn(name = "bid_id"),

			inverseJoinColumns = @JoinColumn(name = "customer_id")

	)
	private List<Customer> customers;
	
	public enum Manufacturer {
		 TOYOTA, VOLKSWAGEN, HYUNDAI, KIA, FORD
	}
	public enum Part {
		MOTOR, WHEEL, STEERING_WHEEL, HEADLIGHTS, GEAR
	}

}