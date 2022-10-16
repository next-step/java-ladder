package laddergame.domain;

import laddergame.domain.linepainter.RandomLinePainter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;
    private People people;

    public Ladder(People people, int countOfLadder) {
        this.lines = IntStream.range(0, countOfLadder)
                .mapToObj( __ -> new Line(people.numberOfPersons(), new RandomLinePainter()))
                .collect(Collectors.toUnmodifiableList());
        this.people = people;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<PersonName> getPersonNames() {
        return people.getNames();
    }
}
