package nextstep.ladder.domain;

import nextstep.ladder.vo.Height;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int ONE = 1;
    private static final int FIRST_PERSON = 0;
    private static final int MINIMUM_LINE_SIZE = 2;

    private final List<Line> lines;
    private final Height heightOfLadder;

    private Ladder(List<Line> lines, int heightOfLadder) {
        validateLine(lines);

        this.lines = Collections.unmodifiableList(lines);
        this.heightOfLadder = new Height(heightOfLadder);
    }

    public static Ladder of(List<Person> persons, int heightOfLadder) {
        List<Line> lines = new ArrayList<>();
        Line previousLine = Line.firstLine(persons.get(FIRST_PERSON), heightOfLadder);
        lines.add(previousLine);
        for (int lineIndex = 1; lineIndex < persons.size(); lineIndex++) {
            previousLine = getLine(persons, previousLine, lineIndex);
            lines.add(previousLine);
        }
        return new Ladder(lines, heightOfLadder);
    }

    private static Line getLine(List<Person> persons, Line previousLine, int lineIndex) {
        if (isLastLine(persons, lineIndex)) {
            return Line.lastLine(persons.get(lineIndex), previousLine.getSteps());
        }
        return Line.middleLine(persons.get(lineIndex), previousLine.getSteps());
    }

    private static boolean isLastLine(List<Person> persons, int lineIndex) {
        return lineIndex == lastPersonsIndex(persons);
    }

    private static int lastPersonsIndex(List<Person> persons) {
        return persons.size() - ONE;
    }

    private void validateLine(List<Line> lines) {
        if (lines.size() < MINIMUM_LINE_SIZE) {
            throw new IllegalArgumentException("라인은 두개 이상이여야 합니다.");
        }
    }

    public int getHeightOfLadder() {
        return heightOfLadder.getHeight();
    }

    public List<Line> getLines() {
        return lines;
    }
}
