package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Ladders {

    public static final int START_INCLUSIVE = 1;

    private final List<Line> lines;

    private Ladders(int countOfPlayer, int maxHeight) {
        this.lines = IntStream.rangeClosed(START_INCLUSIVE, maxHeight)
                .mapToObj(index -> new Line(countOfPlayer))
                .collect(toList());

    }

    private Ladders(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladders of(int countOfPlayer, int maxHeight) {
        return new Ladders(countOfPlayer, maxHeight);
    }

    public static Ladders getDefault(List<Line> lines) {
        return new Ladders(lines);
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }

    public int findLadderResult(int startPosition) {
        int resultColumn = startPosition;

        for (Line line : lines) {
            if (line.canGoRight(resultColumn)) {
                resultColumn++;
                continue;
            }

            if (line.canGoLeft(resultColumn)) {
                resultColumn--;
            }
        }

        return resultColumn;
    }


}
