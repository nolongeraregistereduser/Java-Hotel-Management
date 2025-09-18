import java.util.List;
import java.util.UUID;

public interface ClientRepository {

    void save(Client client);
    Client findById(UUID clientId);
    Client FindByEmail(String email);
    List<Client> findAll();
    void update(Client client);
    void delete(Client client);

}
