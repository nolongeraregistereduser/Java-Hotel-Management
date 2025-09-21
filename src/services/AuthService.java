package services;
import repositories.InMemoryClientRepository;
import models.Client;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AuthService {
    private final InMemoryClientRepository clientRepository;
    private final Set<String> loggedInEmails = new HashSet<>();

    public AuthService(InMemoryClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean register(String email, String password) {
        if (clientRepository.findByEmail(email) != null) {
            return false; // Email already exists
        }
        // You can replace "Default Name" with a real name if you collect it during registration
        Client client = new Client(UUID.randomUUID(), "Default Name", email, password);
        clientRepository.save(client);
        return true;
    }

    public boolean login(String email, String password) {
        Client client = clientRepository.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            loggedInEmails.add(email);
            return true;
        }
        return false;
    }

    public boolean logout(String email) {
        return loggedInEmails.remove(email);
    }

    public boolean isLoggedIn(String email) {
        return loggedInEmails.contains(email);
    }
}
