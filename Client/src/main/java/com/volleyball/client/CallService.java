package com.volleyball.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CallService {
	public void createPlayer() {
		String url = "http://localhost:8080/players/post";

		Players player = new Players();
		player.setPlayerFirstName("Anish");
		player.setPlayerLastName("Doe");
		player.setPlayerPhoneNumber(1234567890);
		player.setPlayerEmail("john.doe@example.com");

		Address address = new Address();
		address.setAddress_1("123 Main St");
		address.setDistrict("Example District");
		address.setState("Example State");
		address.setCountry("Example Country");
		address.setPincode("12345");
		player.setAddress(address);

		JerseyNumber jerseyNumber = new JerseyNumber();
		jerseyNumber.setJerseyNumber(10);
		player.setJerseyNumbers(jerseyNumber);

		PlayerRole playerRole = new PlayerRole();
		playerRole.setPlayerRole("Forward");
		player.setPlayerRole(playerRole);

		NumberOfPoints numberOfPoints = new NumberOfPoints();
		numberOfPoints.setAttacks(20);
		numberOfPoints.setDrops(20);
		numberOfPoints.setServe(10);
		player.setNumberOfPoints(numberOfPoints);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Players> requestEntity = new HttpEntity<>(player, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Players> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				Players.class);

		Players createdPlayer = responseEntity.getBody();

		System.out.println(
				"Created Player Name: " + createdPlayer.getPlayerFirstName() + " " + createdPlayer.getPlayerLastName());
	}

	public List<Players> getApi() {
		String url = "http://localhost:8080/players/get";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<List<Players>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<Players>>() {
				});
		List<Players> playersList = responseEntity.getBody();

		List<Players> selectedPlayers = new ArrayList<>();

		for (Players player : playersList) {
			int totalPoints = player.getNumberOfPoints().getAttacks() + player.getNumberOfPoints().getDrops()
					+ player.getNumberOfPoints().getServe();

			if (totalPoints > 40) {

				System.out.println(player.getPlayerFirstName() + " " + "Selected for National Team");
				selectedPlayers.add(player);
			} else {

				System.out.println(player.getPlayerFirstName() + " " + "Well played, better luck next time");

			}
		}

		System.out.println(selectedPlayers);
		return selectedPlayers;
	}

	public void updatePlayer() {

		// Set the REST API URL for updating the player
		String url = "http://localhost:8080/players/update";
		Players playerToUpdate = new Players();

		// Set the ID of the player to be updated
		playerToUpdate.setPlayerFirstName("Anish");
		playerToUpdate.setPlayerLastName("Doe");
		playerToUpdate.setPlayerPhoneNumber(1234567890);
		playerToUpdate.setPlayerEmail("john.doe@example.com");

		Address address1 = new Address();
		address1.setAddress_1("123 Main St");
		address1.setDistrict("Example District");
		address1.setState("Example State");
		address1.setCountry("Example Country");
		address1.setPincode("12345");
		playerToUpdate.setAddress(address1);

		// Set the jersey number
		JerseyNumber jerseyNumber1 = new JerseyNumber();
		jerseyNumber1.setJerseyNumber(10);
		playerToUpdate.setJerseyNumbers(jerseyNumber1);

		// Set the player role
		PlayerRole playerRole1 = new PlayerRole();
		playerRole1.setPlayerRole("Forward");
		playerToUpdate.setPlayerRole(playerRole1);

		// Set the number of points
		NumberOfPoints numberOfPoints1 = new NumberOfPoints();
		numberOfPoints1.setAttacks(20);
		numberOfPoints1.setDrops(5);
		numberOfPoints1.setServe(10);
		playerToUpdate.setNumberOfPoints(numberOfPoints1);

		// Set the headers with content type
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create the HTTP request entity with the updated player object and headers
		HttpEntity<?> requestEntity = new HttpEntity<>(headers);

		// Create a RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Send the HTTP POST request to update the player
		ResponseEntity<Players> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				Players.class);

		// Get the updated player from the response
		Players updatedPlayer = responseEntity.getBody();

		System.out.println(
				"Updated Player Name: " + updatedPlayer.getPlayerFirstName() + " " + updatedPlayer.getPlayerLastName());
	}

}
