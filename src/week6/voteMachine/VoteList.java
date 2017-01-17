package week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by jotte on 16-1-17.
 */
public class VoteList extends Observable {
    public Map<String, Integer> voteMap;

    public VoteList() {
        this.voteMap = new HashMap<>();

    }

    public void addVote(String party) {
        if (voteMap.containsKey(party)) {
            int partyVotes = this.voteMap.get(party);
            partyVotes++;
            this.voteMap.put(party, partyVotes);
        } else {
            voteMap.put(party, 1);
        }
        setChanged();
        notifyObservers("party");
    }

    public Map<String, Integer> getVotes() {
        return this.voteMap;
    }

}
