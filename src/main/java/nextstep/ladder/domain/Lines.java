package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    public Lines(int heightSize, int participantSize) {
        this(generateLines(heightSize, participantSize));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static List<Line> generateLines(int size, int participantSize) {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lines.add(new Line(participantSize));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public LadderMapping switchOrder(LadderMapping ladderMapping) {
        LadderMapping previous = ladderMapping;
        for (Line line : lines) {
            previous = line.switchOrder(previous);
        }
        return previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lines)) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
