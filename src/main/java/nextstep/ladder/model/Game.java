package nextstep.ladder.model;

import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.player.People;

public class Game {

    private final People people;
    private final Ladder ladder;

    private Game(People people, Ladder ladder) {
        this.people = people;
        this.ladder = ladder;
    }
}
