package com.volleyball.client;

public class VolleyballclientApplication {

	public static void main(String[] args) {

		CallService callService = new CallService();
		callService.createPlayer();
		callService.getApi();
//		callService.updatePlayer();
	}

}
