package nextstep.ladder.model;

import nextstep.ladder.model.ladder.EndPoint;
import nextstep.ladder.model.ladder.EndPoints;
import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.ladder.Lines;
import nextstep.ladder.model.player.People;

import java.util.List;

public class Game {

    private final People people;
    private final Ladder ladder;

    private Game(People people, Ladder ladder) {
        this.people = people;
        this.ladder = ladder;
    }

    public static Game ready(List<String> names, List<String> scores, int maxHeight) {
        People people = People.of(names);
        Ladder ladder = Ladder.create(people.size(), maxHeight, scores);
        return Game.ready(people, ladder);
    }

    public static Game ready(People people, Lines lines, EndPoints endPoints) {
        Ladder ladder = Ladder.create(lines, endPoints);
        return Game.ready(people, ladder);
    }

    public static Game ready(People people, Ladder ladder) {
        return new Game(people, ladder);
    }

    public People people() {
        return this.people;
    }

    public Ladder ladder() {
        return this.ladder;
    }

    public EndPoint result(String name) {
        int sequence = this.people.findSequence(name);
        return this.ladder.findEndPoint(sequence);
    }
}
