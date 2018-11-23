package ladder.domain;

import java.util.List;

public class LadderGame {

    private People people;
    private Ladder ladder;

    private LadderGame(People people, Ladder ladder) {
        this.people = people;
        this.ladder = ladder;
    }

    public static LadderGame from(People people, Ladder ladder) {
        return new LadderGame(people, ladder);
    }

    public List<Person> getPeople() {
        return people.getPeople();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
