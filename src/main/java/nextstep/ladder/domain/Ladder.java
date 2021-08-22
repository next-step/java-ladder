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

    public static Ladder of(List<Person> persons, int heightOfLadder) {
        List<Line> lines = new ArrayList<>();
        
        for (int i = 0; i < heightOfLadder; i++) {
            lines.add(Line.of(persons.size() - 1));
        }

        return new Ladder(lines, persons);
    }

    public List<Line> getLadderLines() {
        return ladderLines;
    }

    public List<Person> persons() {
        return persons;
    }
}
