package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> lines;

    private Ladder(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder from(int countOfLine, Participants participants) {
        List<Line> lines = IntStream.range(0, countOfLine)
                .mapToObj(index -> Line.from(participants.size()))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        // ref: https://www.baeldung.com/java-immutable-list
        return Collections.unmodifiableList(lines);
    }

    public int moveFrom(int beginIndex) {
        int lastIndex = beginIndex;
        for (Line line : lines) {
            lastIndex = line.moveFrom(lastIndex);
        }
        return lastIndex;
    }

    public boolean isMatchPointCount(int count) {
        return lines.get(0).pointSize() == count;
    }
}
