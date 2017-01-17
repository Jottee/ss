package week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by jotte on 16-1-17.
 */
public class PartyList extends Observable {
    public List<String> partyList;

    public PartyList() {
        this.partyList = new ArrayList<>();
    }

    public void addParty(String newParty) {
        this.partyList.add(newParty);
        setChanged();
        notifyObservers("party");
    }

    public List<String> getParties() {
        return this.partyList;
    }

    public boolean hasParty(String party) {
        return this.partyList.contains(party);
    }
}
