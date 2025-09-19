import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
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
                // Menu for logged-in users
                System.out.println("\n=== MENU UTILISATEUR CONNECTÉ ===");
                System.out.println("1. Logout (Déconnexion)");
                // Future: add more options for reservations, etc.
                System.out.println("2. Exit (Quitter)");
                System.out.print(" Choisissez une option : ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // pour consommer le retour chariot

                switch (choice) {
                    case 1:
                        boolean loggedOut = authService.logout(currentEmail);
                        if (loggedOut) {
                            System.out.println("Déconnexion réussie. À bientôt, " + currentEmail + "!");
                            currentEmail = null;
                        } else {
                            System.out.println("Erreur lors de la déconnexion.");
                        }
                        break;

                    case 2:
                        System.out.println("Merci, au revoir !");
                        running = false;
                        break;

                    default:
                        System.out.println("Option invalide, veuillez réessayer.");
                }
            }
        }

        scanner.close();
    }
}
