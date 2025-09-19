package repositories;
import java.util.List;
import java.util.UUID;
import models.Hotel;

public interface HotelRepository {

    void save(Hotel hotel);
    Hotel findById(UUID id);
    List<Hotel> findAll();
    List<Hotel> findByAvailability(boolean onlyAvailable);
    void update(Hotel hotel);
    void delete(UUID hotelId);


                                 }
