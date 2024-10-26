package nextstep.ladder.vo;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Winner;

import java.util.List;

public class Result {
    private final List<Person> persons;
    private final List<Line> lines;
    private final List<Winner> winner;

    public Result(final List<Person> persons, final List<Line> lines, final List<Winner> winner) {
        this.persons = persons;
        this.lines = lines;
        this.winner = winner;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Winner> getWinners() {
        return winner;
    }
}
