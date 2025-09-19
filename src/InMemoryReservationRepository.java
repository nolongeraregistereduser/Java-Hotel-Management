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
        return store.get(reservationId);
    }

    @Override
    public List<Reservation> findAll() {
        return List.copyOf(store.values());
    }

    @Override
    public List<Reservation> findByClient(UUID clientId) {
        return null;
        //return store.values().stream().filter(reservation -> reservation.getClientId().equals(clientId));
    }

    @Override
    public List<Reservation> findByHotel(UUID hotelId) {
        return null;
       // return store.values().stream().filter(reservation -> reservation.getHottelid()

    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public void delete(UUID reservationId) {

    }


}
