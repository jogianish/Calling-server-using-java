package com.volleyball.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Players {
	private String playerFirstName;
	private String playerLastName;
	private long playerPhoneNumber;
	private String playerEmail;
	private Address address;
	private JerseyNumber jerseyNumbers;
	private PlayerRole playerRole;
	private NumberOfPoints numberOfPoints;

}
