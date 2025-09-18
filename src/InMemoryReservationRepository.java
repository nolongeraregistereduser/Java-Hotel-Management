import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InMemoryReservationRepository implements ReservationRepository {

    private final Map<UUID, Reservation> store = new HashMap<>();

    @Override
    public void save(Reservation reservation) {
        store.put(reservation.getReservationId(), reservation);
    }

    @Override
    public Reservation find(UUID reservationId) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return List.of();
    }

    @Override
    public List<Reservation> findByClient(UUID clientId) {
        return List.of();
    }

    @Override
    public List<Reservation> findByHotel(UUID hotelId) {
        return List.of();
    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public void delete(UUID reservationId) {

    }

    @Override
    public Reservation findById(UUID id) {
        return store.get(id);
    }
}
