package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladderLines;
    private final List<Person> persons;

    private Ladder(List<Line> ladderLines, List<Person> persons) {
        this.ladderLines = ladderLines;
        this.persons = persons;
    }

    public static Ladder of(List<Person> persons, LadderHeight heightOfLadder) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < heightOfLadder.height(); i++) {
            List<Boolean> points = new RandomPointStrategy().point(persons.size());
            lines.add(Line.of(points));
        }

        return new Ladder(lines, persons);
    }

    public List<Line> ladderHeight() {
        return ladderLines;
    }

    public List<Person> persons() {
        return persons;
    }
}
