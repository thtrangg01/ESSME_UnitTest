import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class APITest {
    Client client;
    public static String BaseURL = "https://essme.luanbt.live";

    @Before
    public void start() {
        client = ClientBuilder.newClient();
    }
}
