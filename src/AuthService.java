import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthService {
    private final Map<String, String> credentials = new HashMap<>(); // email -> password
    private final Set<String> loggedInEmails = new HashSet<>();

    public boolean register(String email, String password) {
        if (credentials.containsKey(email)) {
            return false; // Email already exists
        }
        credentials.put(email, password);
        return true;
    }

    public boolean login(String email, String password) {
        String storedPassword = credentials.get(email);
        if (storedPassword != null && storedPassword.equals(password)) {
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
