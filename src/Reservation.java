import java.time.Instant;
import java.util.UUID;

public class Reservation {


    private UUID reservationId;
    private Instant timesap;
    private String hottelid;
    private String clientId;
    private int nights;

    public Reservation(UUID reservationId, Instant timesap, String hottelid, String clientId, int nights) {
        this.reservationId = reservationId;
        this.timesap = timesap;
        this.hottelid = hottelid;
        this.clientId = clientId;
        this.nights = nights;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public Instant getTimesap() {
        return timesap;
    }

    public void setTimesap(Instant timesap) {
        this.timesap = timesap;
    }

    public String getHottelid() {
        return hottelid;
    }

    public void setHottelid(String hottelid) {
        this.hottelid = hottelid;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }


}
