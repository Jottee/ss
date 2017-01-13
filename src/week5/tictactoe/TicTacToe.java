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
        Strategy theStrategy;
        theStrategy = new NaiveStrategy();
        for (String arg : args) {
            if (arg.equals("-n")) {
                theStrategy = new NaiveStrategy();
            } else if (arg.equals("-s")) {
                theStrategy = new SmartStrategy();
            }
        }
        Player s0 = new HumanPlayer(args[0], Mark.OO);
//        Player s1 = new HumanPlayer(args[1], Mark.XX);
        ComputerPlayer s1 = new ComputerPlayer(Mark.XX, theStrategy);
        Game game = new Game(s0, s1);
        game.start();
    }
}