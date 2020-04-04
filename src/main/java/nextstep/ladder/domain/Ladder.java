package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Lines lines;
    private final int heightOfLadder;

    public Ladder(Lines lines, int heightOfLadder) {
        this.lines = lines;
        this.heightOfLadder = heightOfLadder;
    }

    public static Ladder of(List<Person> persons, int heightOfLine) {
        Lines lines = new Lines();
        for (Person person : persons) {
            if (lines.size() > 0 && persons.size()-1 != lines.size()) {
                lines.add(Line.of(person, lines));
            } else if (lines.size() == 0) {
                lines.add(Line.first(person, heightOfLine));
            } else if (lines.size() == persons.size() - 1) {
                lines.add(Line.last(person, lines));
            }
        }
        return new Ladder(lines, heightOfLine);
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public Lines getLines() {
        return lines;
    }
}
