package nextstep.ladder.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder ofLines(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder ofRandom(int countOfParticipants, int countOfLine) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, countOfLine)
                .forEach(index -> lines.add(Line.init(countOfParticipants)));
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }
}
