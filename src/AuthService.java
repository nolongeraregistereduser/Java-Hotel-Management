import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthService {
    private final Map<String, String> credentials = new HashMap<>(); // username -> password
    private final Set<String> loggedInUsers = new HashSet<>();

    public boolean register(String username, String password) {
        if (credentials.containsKey(username)) {
            return false; // Username already exists
        }
        credentials.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        String storedPassword = credentials.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            loggedInUsers.add(username);
            return true;
        }
        return false;
    }

    public boolean logout(String username) {
        return loggedInUsers.remove(username);
    }

    public boolean isLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}

