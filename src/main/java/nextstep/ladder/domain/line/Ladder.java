package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START = 0;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(LineGenerator lineGenerator, int ladderHeight, int countOfPerson) {
        IntStream.range(START, ladderHeight)
                .forEach(i -> lines.add(new Line(lineGenerator, countOfPerson)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.lines.getClass() != o.getClass()) return false;
        List<Line> otherLines = (List<Line>) o;
        if (lines.size() != otherLines.size()) return false;
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).equals(otherLines.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
