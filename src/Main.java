//import controller.GameController;
import controller.GameController;
import games.Gomoku;
import games.Puissance4;
import games.TicTacToe;
import view.View;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Welcome to GenericGame.TicTacToe!");
//        TicTacToe ticTacToe = new TicTacToe();
//        ticTacToe.play();

//        Gomoku gomoku = new Gomoku();
//        gomoku.play();

//        Puissance4 puissance4 = new Puissance4();
//        puissance4.play();

        // on crée la view
        View view = new View();

//       on crée le controller
        GameController controller = new GameController(view);
//
//       le joueur choisi le jeu
        view.chooseGameType();
        String gameType = view.getUserChoice();

//       commence la partie
        controller.startGame(gameType);
    }
}
