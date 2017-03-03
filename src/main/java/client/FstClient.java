package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class FstClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://korrespondent.net/");

		String response = target.request().get(String.class);

		System.out.println(response);

		client.close();




	}
}
