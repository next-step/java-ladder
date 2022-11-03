package ladder.domain;

import static ladder.domain.Point.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EdgeLine extends Line {
    public EdgeLine(final int countOfPerson) {
        super(countOfPerson);
    }

    public EdgeLine(Point... points) {
        super(new Points(Arrays.stream(points).collect(Collectors.toList())));
    }

    @Override
    protected Point choiceBeforeLast(final Point before) {
        return choicePoint(List.of(HORIZON, BLANK));
    }
}
