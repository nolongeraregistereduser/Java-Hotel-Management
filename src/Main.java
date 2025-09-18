import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    // TODO : Appeler AuthService.register()
                    break;

                case 2:
                    System.out.println("➡ Vous avez choisi : Connexion");
                    // TODO : Appeler AuthService.login()
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
