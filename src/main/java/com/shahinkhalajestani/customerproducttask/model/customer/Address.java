package com.shahinkhalajestani.customerproducttask.model.customer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "province")
	private String province;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(name = "house_number")
	private String houseNumber;

	public String getFullAddress() {
		return street + " " + city + " " + province + " " + postalCode + " " + houseNumber;
	}

}
