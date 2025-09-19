package repositories;
import models.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository
{
    void save(Reservation reservation);
    Reservation find(UUID reservationId);
    List<Reservation> findAll();
    List<Reservation> findByClient(UUID clientId);
    List<Reservation> findByHotel(UUID hotelId);
    void update(Reservation reservation);
    void delete(UUID reservationId);

}
