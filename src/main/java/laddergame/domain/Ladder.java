package laddergame.domain;

import laddergame.domain.linepainter.RandomLinePainter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> lines;
    Persons persons;


    public Ladder(Persons persons, int countOfLadder) {
        this.lines = IntStream.range(0, countOfLadder)
                .mapToObj(a -> new Line(persons.numberOfPersons(), new RandomLinePainter()))
                .collect(Collectors.toUnmodifiableList());
        this.persons = persons;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<PersonName> getPersonNames() {
        return persons.getNames();
    }
}
