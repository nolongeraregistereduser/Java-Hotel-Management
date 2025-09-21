import models.Hotel;
import repositories.HotelRepository;
import repositories.InMemoryHotelRepository;
import repositories.InMemoryClientRepository;
import services.AuthService;
import services.ReservationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryClientRepository clientRepository = new InMemoryClientRepository();
        AuthService authService = new AuthService(clientRepository);
        boolean running = true;
        String currentEmail = null;

        while (running) {
            if (currentEmail == null) {
                // Menu for not logged-in users
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Register (Inscription)");
                System.out.println("2. Login (Connexion)");
                System.out.println("3. Exit (Quitter)");
                System.out.print(" Choisissez une option : ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // pour consommer le retour chariot

                // Traitement du choix
                switch (choice) {
                    case 1:
                        System.out.println("➡ Vous avez choisi : Inscription");
                        System.out.print("Entrez l'email : ");
                        String regEmail = scanner.nextLine();
                        System.out.print("Entrez le mot de passe : ");
                        String regPassword = scanner.nextLine();
                        boolean registered = authService.register(regEmail, regPassword);
                        if (registered) {
                            System.out.println("Inscription réussie !");
                        } else {
                            System.out.println("Email déjà utilisé.");
                        }
                        break;

                    case 2:
                        System.out.println("➡ Vous avez choisi : Connexion");
                        System.out.print("Entrez l'email : ");
                        String loginEmail = scanner.nextLine();
                        System.out.print("Entrez le mot de passe : ");
                        String loginPassword = scanner.nextLine();
                        boolean loggedIn = authService.login(loginEmail, loginPassword);
                        if (loggedIn) {
                            currentEmail = loginEmail;
                            System.out.println("Connexion réussie ! Bienvenue, " + currentEmail + ".");
                        } else {
                            System.out.println("Email ou mot de passe incorrect.");
                        }
                        break;

                    case 3:
                        System.out.println("Merci, au revoir !");
                        running = false;
                        break;

                    default:
                        System.out.println("Option invalide, veuillez réessayer.");
                }
            } else {
                // Menu for logged-in users (client)
                System.out.println("\n=== MENU UTILISATEUR CONNECTÉ ===");
                System.out.println("1. Voir tous les hôtels");
                System.out.println("2. Voir les hôtels disponibles");
                System.out.println("3. Rechercher des hôtels par note");
                System.out.println("4. Déconnexion");
                System.out.println("5. Quitter");
                System.out.println("6 : Réserver une chambre dans un hotel ? ");
                System.out.print(" Choisissez une option : ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // pour consommer le retour chariot

                // initialiser inmemoryhotelrepository ici pour éviter de le faire plusieurs fois
                HotelRepository hotelRepoInit = new InMemoryHotelRepository();

                // Traitement du choix

                switch (choice) {
                    case 1:
                        System.out.println("Liste des hôtels :");
                        for (Hotel hotel : hotelRepoInit.findAll()) {
                            System.out.println("- " + hotel.getAddress() + " | Chambres disponibles: " + hotel.getAvailableRooms() + " | Note: " + hotel.getRating());
                        }
                        break;
                    case 2:
                        System.out.println("Hôtels disponibles :");
                        for (Hotel hotel : hotelRepoInit.findByAvailability(true)) {
                            System.out.println("- " + hotel.getAddress() + " | Chambres disponibles: " + hotel.getAvailableRooms() + " | Note: " + hotel.getRating());
                        }
                        break;
                    case 3:
                        System.out.print("Entrez la note minimale (0.0 - 5.0) : ");
                        double minRating = scanner.nextDouble();
                        scanner.nextLine(); // pour consommer le retour chariot
                        System.out.println("Hôtels avec une note minimale de " + minRating + " :");
                        for (Hotel hotel : hotelRepoInit.findAll()) {
                            if (hotel.getRating() >= minRating) {
                                System.out.println("- " + hotel.getAddress() + " | Chambres disponibles: " + hotel.getAvailableRooms() + " | Note: " + hotel.getRating());
                            }
                        }
                        break;
                    case 4:
                        boolean loggedOut = authService.logout(currentEmail);
                        if (loggedOut) {
                            System.out.println("Déconnexion réussie. À bientôt, " + currentEmail + "!");
                            currentEmail = null;
                        } else {
                            System.out.println("Erreur lors de la déconnexion.");
                        }
                        break;
                    case 5:
                        System.out.println("Merci, au revoir !");
                        running = false;
                        break;
                    case 6:
                        System.out.println("Liste des hotels disponible : ");
                        for (Hotel hotel : hotelRepoInit.findByAvailability(true)) {
                            System.out.println(" Numero "+ hotel.getHotelId() + "- " + hotel.getAddress() + " | Chambres disponibles: " + hotel.getAvailableRooms() + " | Note: " + hotel.getRating());
                        }
                        System.out.println("Entrez l'ID de l'hôtel où vous souhaitez réserver une chambre : ");
                        String hotelIdStr = scanner.nextLine();
                        System.out.println("Entrez le nombre de nuits pour la réservation : ");
                        int nights = scanner.nextInt();
                        scanner.nextLine(); // pour consommer le retour chariot
                        // Appel du service de réservation ici (à implémenter)
                        ReservationService reservationService = new ReservationService(authService, null);
                        boolean reservationSuccess = reservationService.makeReservation(currentEmail, authService.getClientRepository().findByEmail(currentEmail).getPassword(), java.util.UUID.fromString(hotelIdStr), nights);
                        if (reservationSuccess) {
                            System.out.println("Réservation réussie !");
                        } else {
                            System.out.println("Échec de la réservation. Veuillez vérifier les informations et réessayer.");
                        }

                        break;
                    default:
                        System.out.println("Option invalide, veuillez réessayer.");
                }
            }
        }

        scanner.close();
    }
}
