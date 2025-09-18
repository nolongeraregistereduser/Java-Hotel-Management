import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class InMemoryClientRepository {
    private final Map<UUID, Client> store = new HashMap<>();

    public void save(Client client) {
        store.put(client.getClientId(), client);
    }

    public Client findById(UUID id) {
        return store.get(id);
    }

    public Client findByEmail(String email) {
        // Loop through all clients in the store
        for (Client client : store.values()) {
            // Check if this client's email matches the search email
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        // If no client with that email is found, return null
        return null;
    }

}
