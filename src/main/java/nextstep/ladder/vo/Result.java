package nextstep.ladder.vo;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;

import java.util.List;

public class Result {
    private final List<Person> persons;
    private final List<Line> lines;

    public Result(final List<Person> persons, final List<Line> lines) {
        this.persons = persons;
        this.lines = lines;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Line> getLines() {
        return lines;
    }
}
