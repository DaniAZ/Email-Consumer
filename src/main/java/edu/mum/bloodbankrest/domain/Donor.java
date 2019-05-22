package edu.mum.bloodbankrest.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties
public class Donor{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;


	private int age;


	private double weight;

	@Email
	private String email;
	private String phoneNumber;
	private String medicalHistory;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="donorId")
	UserCredentials userCredentials;

	@OneToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Address address;

	@OneToMany(mappedBy="donor",fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Donation> donations = new HashSet<Donation>();


	public Donor() {}

	public Donor(String firstName, String lastName, int age, double weight, String email, String phoneNumber,
			String medicalHistory) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.weight = weight;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.medicalHistory = medicalHistory;
	}

	public void addDonation(Donation donation) {
		this.donations.add(donation);
		donation.setDonor(this);
	}
}
