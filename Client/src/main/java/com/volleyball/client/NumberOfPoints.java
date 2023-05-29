package com.volleyball.client;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class NumberOfPoints {
	private int attacks;
	private int drops;
	private int serve;
	private int totalPoints;
	private Players players;
}
