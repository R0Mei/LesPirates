package tools;

import java.util.Scanner;

public class Entrer {
    private Affichage affichage;
    private Scanner scanner;
    public Entrer() {
        affichage = new Affichage();
        scanner = new Scanner(System.in);
    }

    public int entrer123() {
        int input;
        do {
            affichage.displayMessage("Entrez 1, 2 ou 3 : ");
            while (!scanner.hasNextInt()) {
                affichage.displayMessage("Ce n'est pas un entier. Entrez 1, 2 ou 3 : ");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < 1 || input > 3);
        return input;
    }
    public int entrer1234() {
        int input;
        do {
            affichage.displayMessage("Entrez 1, 2, 3 ou 4 : ");
            while (!scanner.hasNextInt()) {
                affichage.displayMessage("Ce n'est pas un entier. Entrez 1, 2, 3 ou 4 : ");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < 1 || input > 4);
        return input;
    }
    public void waitForEnter() {
        scanner.nextLine();
    }
    public String askForName(int playerNumber) {
	    Scanner scanner = new Scanner(System.in);
	    affichage.displayMessage("Entrez le prénom du joueur " + playerNumber + ": ");
	    return scanner.nextLine();
	}
}
