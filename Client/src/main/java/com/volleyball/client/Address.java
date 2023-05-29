package com.volleyball.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private long addressId;

	private String address_1;

	private String address_2;

	private String district;

	private String state;

	private String country;

	private String pincode;

	private Players players;

}
