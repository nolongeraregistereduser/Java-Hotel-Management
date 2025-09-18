import java.util.UUID;

public class Client {

    private UUID clientId;
    private String fullName;
    private String email;
    private String password;

    public Client(UUID clientId, String fullName, String email, String password) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;

    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
