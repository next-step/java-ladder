package ladder.domain;

public class LadderGame {

    private final People people;
    private final Ladder ladder;

    public LadderGame(People people, Height height) {
        this.people = people;
        this.ladder = new Ladder(height, people);
    }

    public Ladder ladder() {
        return ladder;
    }

    public People people() {
        return people;
    }
}
