package services;
import models.Reservation;
import repositories.InMemoryReservationRepository;
import services.AuthService;
import repositories.ReservationRepository;
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

    public boolean makeReservation(String email, String password, UUID hotelId, int nights) {
        if (authService.login(email, password)) {
            // Find the client by email
            Client client = authService.getClientRepository().findByEmail(email);
            if (client == null) return false;

            UUID clientId = client.getClientId();
            Reservation reservation = new Reservation(UUID.randomUUID(), Instant.now(), hotelId, clientId, nights);
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }



    public boolean cancelReservation(String email, String password) {
        if (authService.login(email, password)) {
            // Logic to find and delete a reservation
            // reservationRepository.delete(reservationId);
            return true;
        }
        return false;
    }
}
