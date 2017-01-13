package week5.tictactoe;

/**
 * Created by jotte on 10-1-17.
 */
public class ComputerPlayer extends Player{

    private Strategy myStrategy;
    private Mark mark;


    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + "-" + mark.name(), mark);
        this.myStrategy = strategy;
    }

    public ComputerPlayer(Mark mark) {
        super(new NaiveStrategy().getName() + "-" + mark.name(), mark);
        this.myStrategy = new NaiveStrategy();
    }

    @Override
    public int determineMove(Board board) {
        return myStrategy.determineMove(board, mark);
    }

    @Override
    public String getName() {
        return "" + myStrategy.getName() + "-" + mark.name();
    }
}
