package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<RowLine> rowLines;

    public Ladder(List<RowLine> rowLines) {
        this.rowLines = rowLines;
    }

    public static Ladder of(int height, RowLineFactory factory) {
        return new Ladder(
            IntStream.range(0, height)
                .mapToObj(i -> factory.line())
                .collect(Collectors.toList()));
    }

    public List<RowLine> lines() {
        return rowLines;
    }

    public int ladderSize() {
        return rowLines.size();
    }

}
