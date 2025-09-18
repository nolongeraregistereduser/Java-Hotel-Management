import java.util.UUID;

public class Hotel {
    private UUID hotelId;
    private String address;
    private int availableRooms;
    private double rating;


    public Hotel(UUID hotelId, String address, int availableRooms, double rating) {
        this.hotelId = hotelId;
        this.address = address;
        this.availableRooms = availableRooms;
        this.rating = rating;

    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        if(availableRooms <= 0){
            return false;
        }
        return true;
    }

    }
