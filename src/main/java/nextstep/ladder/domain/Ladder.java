package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladderLines;
    private final Persons persons;

    private Ladder(List<Line> ladderLines, Persons persons) {
        this.ladderLines = ladderLines;
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

    public List<Line> ladderHeight() {
        return ladderLines;
    }

    public Persons persons() {
        return persons;
    }
}
