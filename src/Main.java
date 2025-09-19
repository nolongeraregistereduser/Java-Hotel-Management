import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        boolean running = true;

        while (running) {
            // Affichage du menu
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
                    System.out.print("Entrez le nom d'utilisateur : ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Entrez le mot de passe : ");
                    String regPassword = scanner.nextLine();
                    boolean registered = authService.register(regUsername, regPassword);
                    if (registered) {
                        System.out.println("Inscription réussie !");
                    } else {
                        System.out.println("Nom d'utilisateur déjà utilisé.");
                    }
                    break;

                case 2:
                    System.out.println("➡ Vous avez choisi : Connexion");
                    System.out.print("Entrez le nom d'utilisateur : ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Entrez le mot de passe : ");
                    String loginPassword = scanner.nextLine();
                    boolean loggedIn = authService.login(loginUsername, loginPassword);
                    if (loggedIn) {
                        System.out.println("Connexion réussie !");
                    } else {
                        System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
                    }
                    break;

                case 3:
                    System.out.println("Merci, au revoir !");
                    running = false;
                    break;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
