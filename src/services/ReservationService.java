package services;
import models.Reservation;
import repositories.InMemoryReservationRepository;
import services.AuthService;
import models.Client;

import java.time.Instant;
import java.util.UUID;

public class ReservationService {

    private final AuthService authService;
    private final InMemoryReservationRepository reservationRepository;

    public ReservationService(AuthService authService, InMemoryReservationRepository reservationRepository) {
        this.authService = authService;
        this.reservationRepository = reservationRepository;
    }

    public boolean makeReservation(String email, UUID hotelId, int nights) {
        // User is already logged in, so no need to check password again
        Client client = authService.getClientRepository().findByEmail(email);
        if (client == null) return false;

        UUID clientId = client.getClientId();
        Reservation reservation = new Reservation(UUID.randomUUID(), Instant.now(), hotelId, clientId, nights);
        reservationRepository.save(reservation);
        return true;
    }



public boolean cancelReservation(UUID reservationId, String email) {
        Client client = authService.getClientRepository().findByEmail(email);
        if (client == null) return false;

        Reservation reservation = reservationRepository.find(reservationId);
        if (reservation == null || !reservation.getClientId().equals(client.getClientId().toString())) {
            return false; // Reservation not found or does not belong to the client
        }

        reservationRepository.delete(reservationId);

        return true;
    }
}
