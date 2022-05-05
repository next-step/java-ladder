package nextstep.step4.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Ladder {

    public static final int START_INCLUSIVE = 1;

    private final List<Line> ladder;

    private Ladder(int countOfPlayer, int maxHeight) {
        this.ladder = IntStream.rangeClosed(START_INCLUSIVE, maxHeight)
                .mapToObj(index -> Line.from(countOfPlayer))
                .collect(toList());
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int countOfPerson, int maxHeight) {
        return new Ladder(countOfPerson, maxHeight);
    }

    public int findEndColumByStartColumn(int startColumn) {
        int resultColumn = startColumn;

        for (Line line : ladder) {
            resultColumn = line.move(resultColumn);
        }

        return resultColumn;
    }

    public List<Line> getLadder() {
        return unmodifiableList(ladder);
    }
}
