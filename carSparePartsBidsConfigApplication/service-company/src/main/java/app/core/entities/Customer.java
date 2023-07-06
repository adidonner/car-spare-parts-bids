package app.core.entities;

//import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "bids" )
@EqualsAndHashCode(of = "id")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length = 4)
	private String password;
	@Column(length = 10)
	private String phoneNumber;
	
	@ManyToMany
	@JoinTable(

			name = "customer_bid",

			joinColumns = @JoinColumn(name = "customer_id"),

			inverseJoinColumns = @JoinColumn(name = "bid_id")

	)
	private List<Bid> bids;

//	public void addBid(Bid bid) {
//		if (bids == null) {
//			bids = new ArrayList<>();
//		}
//		bids.add(bid);
//	}
	
}
