package view;

import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner;

    // construct
    public InteractionUtilisateur() {

        this.scanner = new Scanner(System.in);
    }

    // methode pour récupérer du joueur la reponse à la question contre qui il veut jouer
    public String recoveryAnswer() {
        return scanner.nextLine();
    }

    // methode pour récupérer la position de la pièce à jouer
    public int[] recoveryAnswerInt() {
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int row = Integer.parseInt(inputs[0]);
        int col = Integer.parseInt(inputs[1]);
        return new int[]{row, col};
    }

    // methode pour demander si l'utilisateur veut quitter le jeu
//    public boolean exitGame() {
//        return scanner.nextLine().equalsIgnoreCase("| X");
//    }
}
