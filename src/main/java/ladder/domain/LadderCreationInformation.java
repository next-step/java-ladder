package ladder.domain;

public final class LadderCreationInformation {

    private final People people;
    private final LadderHeight ladderHeight;

    private LadderCreationInformation(People people, LadderHeight ladderHeight) {
        this.people = people;
        this.ladderHeight = ladderHeight;
    }

    public static final LadderCreationInformation from(People people, LadderHeight ladderHeight) {
        return new LadderCreationInformation(people, ladderHeight);
    }
}
