package week5.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 *
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        Strategy strat = null;
        for (String arg : args) {
            if (arg.equals("-n")) {
                strat = new NaiveStrategy();
            } else if (arg.equals("-s")) {
                strat = new NaiveStrategy();
            }
            Player s0 = new ComputerPlayer(Mark.OO, strat);
            Player s1 = new HumanPlayer(args[1], Mark.XX);
            Game game = new Game(s0, s1);
            game.start();
        }
    }
}