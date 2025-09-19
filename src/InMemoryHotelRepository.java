import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InMemoryHotelRepository implements HotelRepository {
    private final Map<UUID, Hotel> store = new HashMap<>();

    public InMemoryHotelRepository() {
        // Hardcoded Moroccan hotels for testing
        save(new Hotel(UUID.randomUUID(), "La Mamounia", 10, 4.8));
        save(new Hotel(UUID.randomUUID(), "Royal Mansour", 5, 4.9));
        save(new Hotel(UUID.randomUUID(), "Four Seasons Resort Marrakech", 8, 4.7));
        save(new Hotel(UUID.randomUUID(), "Sofitel Casablanca Tour Blanche", 12, 4.5));
        save(new Hotel(UUID.randomUUID(), "Kenzi Tower Hotel", 7, 4.3));
    }

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