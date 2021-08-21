package laddergame.domain;

import java.util.List;

public class LadderGame {

    private final People people;
    private final Ladder ladder;

    public LadderGame(List<String> peopleString, int heightOfLadder) {
        this.people = new People(peopleString);
        this.ladder = new Ladder(people.size(), heightOfLadder);
    }

    public People getPeople() {
        return people;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
