package edu.mum.bloodbankrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@JsonIgnoreProperties
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean viable = true;
	private int quantity;

	@Future
	private LocalDate donationDate;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="blood_drive_id")
	private BloodDrive bloodDrive;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="donor_id")
	private Donor donor;

	public Donation() {
	}
	public Donation(Long id, Boolean viable, int quantity,LocalDate donationDate,Donor donor) {
		this.id = id;
		this.viable = viable;
		this.quantity = quantity;
       this.donationDate=donationDate;
	}

	public void setBloodDrive(BloodDrive bloodDrive) {
		this.bloodDrive = bloodDrive;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

}
