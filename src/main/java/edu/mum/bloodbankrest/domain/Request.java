package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private BloodType bloodType;

	private int quantity;

	@OneToOne
	private Status status;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
	public Request() {}

	public Request(Long id, BloodType bloodType, int quantity, Status status) {
		this.id = id;
	   this.bloodType = bloodType;
		this.quantity = quantity;
		this.status = status;
		
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Hospital getHospital() {
		return hospital;
	}
}
