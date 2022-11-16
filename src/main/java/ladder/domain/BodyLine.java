package ladder.domain;

import static ladder.domain.Point.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BodyLine extends Line {
    public BodyLine(final int countOfPerson) {
        super(countOfPerson);
    }

    public BodyLine(Point... points) {
        super(new Points(Arrays.stream(points).collect(Collectors.toList())));
    }

    @Override
    protected Point choiceBeforeLast(final Point before) {
        if (before == HORIZON) {
            return HORIZON;
        }
        if (before == VERTICAL_LINE) {
            return choicePoint(List.of(HORIZON, BLANK));
        }
        return BLANK;
    }
}
