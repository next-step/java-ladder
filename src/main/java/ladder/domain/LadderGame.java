package ladder.domain;


import java.util.List;

public class LadderGame {

    private Persons persons;
    private Ladder ladder;
    private LadderWinnings ladderWinning;

    public LadderGame(final String names, final int ladderHeight, final String winnings) {
        initLadderGame(names, ladderHeight, winnings);
    }

    private void initLadderGame(final String names, final int ladderHeight, final String winnings) {
        this.persons = new Persons(names);
        this.ladderWinning = new LadderWinnings(winnings, this.persons);
        this.ladder = new Ladder(ladderHeight, persons.getPersons().size());
    }

    public List<LadderWinning> getWinnings() {
        return ladderWinning.getWinnings();
    }

    public Persons getPerson() {
        return persons;
    }

    public Ladder getLadder() {
        return ladder;
    }
}