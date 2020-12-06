package ladder.domain;


public class LadderGame {
    private Persons person;
    private LadderLine ladderLine;

    public LadderGame(final String names, final int ladderHeight) {
        initLadderGame(names, ladderHeight);
    }

    private void initLadderGame(final String names, final int ladderHeight) {
        this.person = new Persons(names);
        this.ladderLine = new LadderLine(ladderHeight, person.getPersons().size());
    }

    public Persons getPerson() {
        return person;
    }

    public LadderLine getLadderLine() {
        return ladderLine;
    }
}
