package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Data
public class Address {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String street;
	@NotEmpty
	private String city;

	@Size(min = 5, max = 10)
	private String zipCode;

	@OneToOne
	private State state;

	public Address() {
	}
	public Address(String street, String city, String zipCode,State state) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.state=state;
	}

	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", zipCode='" + zipCode + '\'' +
				", state=" + state +
				'}';
	}
}
