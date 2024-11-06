package nextstep.ladder.vo;

import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Person;
import nextstep.ladder.engine.Winner;

import java.util.List;

public class Result {
    private final List<Person> persons;
    private final List<Line> lines;
    private final List<Winner> winners;

    public Result(final List<Person> persons, final List<Line> lines, final List<Winner> winners) {
        this.persons = persons;
        this.lines = lines;
        this.winners = winners;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Winner> getWinners() {
        return winners;
    }
}
