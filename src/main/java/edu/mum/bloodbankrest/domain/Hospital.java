package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Email
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy="hospital",fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Request> requests = new ArrayList<>();

	public Hospital() {}

	public Hospital(String name, Address address, List<Request> requests,String email) {
		this.name = name;
		this.address = address;
		this.requests = requests;
		this.email=email;
	}

	public void addRequest(Request request) {
		this.requests.add(request);
		request.setHospital(this);
	}


}
