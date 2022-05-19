package nextstep.ladder.model;

import java.util.List;

public class Ladder {

    private final List<Person> people;
    private final List<Line> lines;

    private Ladder(List<Person> people, List<Line> lines) {
        this.people = people;
        this.lines = lines;
    }

    public static Ladder start(List<Person> people, List<Line> lines) {
        return new Ladder(people, lines);
    }

    public List<Person> people() {
        return this.people;
    }

    public List<Line> lines() {
        return this.lines;
    }
}
