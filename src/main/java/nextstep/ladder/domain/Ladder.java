package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final Persons persons;

    private Ladder(List<Line> lines, Persons persons) {
        this.lines = lines;
        this.persons = persons;
    }

    public static Ladder of(Persons persons, LadderHeight heightOfLadder) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < heightOfLadder.height(); i++) {
            List<Boolean> points = new RandomPointStrategy().point(persons.size());
            lines.add(Line.of(points));
        }

        return new Ladder(lines, persons);
    }

    public static Ladder of(Line lines, Persons persons) {
        return new Ladder(Collections.singletonList(lines), persons);
    }

    public List<Line> lines() {
        return lines;
    }

    public Persons persons() {
        return persons;
    }

    public int resultPersonIndex(String name) {
        int position = persons.findIndexOfPerson(name);

        for (Line line : lines) {
            position = line.currentPosition(position);
        }

        return position;
    }
}
