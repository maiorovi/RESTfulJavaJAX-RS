package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class GetRequestClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://stackoverflow.com/questions/27211012/how-to-send-json-object-from-rest-client-using-javax-ws-rs-client-webtarget");

		String response = target.request().get(String.class);

		System.out.println(response);

		client.close();




	}
}
