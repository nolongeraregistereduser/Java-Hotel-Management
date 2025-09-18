import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InMemoryHotelRepository implements HotelRepository {
    private final Map<UUID, Hotel> store = new HashMap<>();

    @Override
    public void save(Hotel hotel) {
        store.put(hotel.getHotelId(), hotel);
    }

    @Override
    public Hotel findById(UUID id) {
        return store.get(id);
    }

    @Override
    public List<Hotel> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Hotel> findByAvailability(boolean onlyAvailable) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : store.values()) {
            if (!onlyAvailable || hotel.isAvailable()) {
                result.add(hotel);
            }
        }
        return result;
    }

    @Override
    public void update(Hotel hotel) {
        store.put(hotel.getHotelId(), hotel);
    }

    @Override
    public void delete(UUID hotelId) {
        store.remove(hotelId);
    }
}