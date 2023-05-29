package com.volleyball.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JerseyNumber {
	private int jerseyNumber;
	private Players players;
}
