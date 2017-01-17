package week6.voteMachine;

import java.util.*;

/**
 * Created by jotte on 16-1-17.
 */
public class VoteTUIView implements Observer, VoteView {

    public VoteList voteList;
    public PartyList partyList;
    public VoteMachine controller;
    protected String lineParty;
    protected String lineVote;

    public VoteTUIView(VoteMachine controller) {
        this.controller = controller;
    }

    public void start() {
        boolean continueOptions = true;
        Scanner in = new Scanner(System.in);
        String line = "";
        System.out.println("Options: \n 1: VOTE [party] \n 2: ADD PARTY [party] " +
                "\n 3: VOTES \n 4: PARTIES \n 5: EXIT");
        while (in.hasNext() && continueOptions) {
            line = in.nextLine();
            int choice = inputToInt(line);
            switch (choice) {
                case 1:
                    this.controller.addVote(lineVote);
                    break;
                case 2:
                    this.controller.addParty(lineParty);
                    break;
                case 3:
                    getVotes();
                    break;
                case 4:
                    getParties();
                    break;
                case 5:
                    continueOptions = false;
                    break;
                case 6:
                    System.out.println("Help menu");
                    break;
                case 7:
                    System.out.println("Enter a choice");
                    break;

            }
        }
    }

    @Override
    public void showVotes(Map<String, Integer> votes) {
        System.out.println("Current votes:");
        Set<String> keySet = votes.keySet();
        for (String key : keySet) {
            System.out.println("Party: " + key + " has " + votes.get(key) + " votes");
        }
    }

    @Override
    public void showParties(List<String> parties) {
        System.out.println("Current parties:");
        for (String party : parties) {
            System.out.println(party);
        }
    }

    private int inputToInt(String line) {
        int ans;
        Scanner scan = new Scanner(line);
        String first = scan.next();
        switch (first) {
            case "VOTE":
                if (scan.hasNext()) {
                    lineVote = scan.nextLine();
                    lineVote.replaceAll("\\s", "");
                }
                ans = 1;
                break;
            case "ADD":
                if (scan.next().equals("PARTY")) {
                    lineParty = scan.nextLine();
                    lineParty.replaceAll("\\s", "");
                }
                ans = 2;
                break;
            case "VOTES":
                System.out.println("The votes:");
                ans = 3;
                break;
            case "PARTIES":
                ans = 4;
                break;
            case "EXIT":
                ans = 5;
                break;
            case "HELP":
                ans = 6;
                break;
            default:
                ans = 7;
        }
        scan.close();
        return ans;


    }

    public void getVotes() {
        System.out.println("Current votes:");
        Set<String> keySet = voteList.getVotes().keySet();
        for (String key : keySet) {
            System.out.println("Party: " + key + " has " + voteList.getVotes().get(key) + " votes");
        }
    }

    public void getParties() {
        System.out.println("Current parties:");
        for (String party : partyList.getParties()) {
            System.out.println(party);
        }
    }

    public void showError(String error) {
        System.out.println(error);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o.equals("vote")) {
            System.out.println("Someone has voted");
        } else if (o.equals("party")) {
            System.out.println("A party has been added");
        } else {
            System.out.println("Wrong command");
        }

    }
}
