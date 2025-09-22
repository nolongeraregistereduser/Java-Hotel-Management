package repositories;
import models.Reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return store.values().stream()
            .filter(reservation -> reservation.getClientId().equals(clientId.toString()))
            .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByHotel(UUID hotelId) {
        return store.values().stream()
            .filter(reservation -> reservation.getHottelid().equals(hotelId.toString()))
            .collect(Collectors.toList());
    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public void delete(UUID reservationId) {
        store.remove(reservationId);
    }


}
