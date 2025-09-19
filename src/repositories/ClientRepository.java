package repositories;
import java.util.List;
import java.util.UUID;
import models.Client;

public interface ClientRepository {

    void save(Client client);
    Client findById(UUID clientId);
    Client findByEmail(String email);
    List<Client> findAll();
    void update(Client client);
    void delete(Client client);

}
