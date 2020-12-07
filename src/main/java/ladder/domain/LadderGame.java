package ladder.domain;


public class LadderGame {
    private Persons persons;
    private LadderLines ladderLine;

    public LadderGame(final String names, final int ladderHeight) {
        initLadderGame(names, ladderHeight);
    }

    private void initLadderGame(final String names, final int ladderHeight) {
        this.persons = new Persons(names);
        this.ladderLine = new LadderLines(ladderHeight, persons.getPersons().size());
    }

    public Persons getPerson() {
        return persons;
    }

    public LadderLines getLadderLine() {
        return ladderLine;
    }
}
