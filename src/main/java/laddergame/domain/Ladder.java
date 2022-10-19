package laddergame.domain;

import laddergame.domain.linepainter.RandomLinePainter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final PersonName ALL = new PersonName("all");

    private List<Line> lines;
    private final People people;

    public Ladder(People people, int countOfLadder) {
        this.lines = IntStream.range(0, countOfLadder)
                .mapToObj(__ -> new Line(people.numberOfPeople(), new RandomLinePainter()))
                .collect(Collectors.toUnmodifiableList());
        this.people = people;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<PersonName> getPersonNames() {
        return people.getNames();
    }

    public Map<PersonName, String> getResult(PersonName personName, Rewards rewards) {

         if(ALL.equals(personName)){
            return getResultAll(rewards);
        }

        if(people.contains(personName)){
            return getResultOne(personName, rewards);
        }
        throw new IllegalArgumentException();
    }

    private Map<PersonName, String> getResultOne(PersonName personName, Rewards rewards) {
        return new HashMap<>();
    }

    private Map<PersonName, String> getResultAll(Rewards rewards) {
        return new HashMap<>();
    }

}
