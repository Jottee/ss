package week6.voteMachine;

import week6.voteMachine.gui.VoteGUIView;

import java.util.List;
import java.util.Map;

/**
 * Created by jotte on 16-1-17.
 */
public class VoteMachine {

    public VoteMachine voteMachine;
    public PartyList pl;
    public VoteList vl;
    public VoteTUIView voteTui;
    public VoteGUIView voteGui;

    public VoteMachine() {
        this.voteMachine = new VoteMachine();
        this.vl = new VoteList();
        this.pl = new PartyList();
        this.voteGui = new VoteGUIView(voteMachine);
        pl.addObserver(voteTui);
        vl.addObserver(voteTui);
        voteTui.start();
    }

    public static void main(String[] args) {
        VoteMachine vm = new VoteMachine();
        vm.start();
    }

    public void addParty(String party) {
        this.pl.addParty(party);
    }

    public void addVote(String party) {
        this.vl.addVote(party);
    }

    private static void start() {

    }

    public List<String> getParties() {
        return pl.getParties();
    }

    public Map<String, Integer> getVotes() {
        return vl.getVotes();
    }
}
