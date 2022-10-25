package ladder.domain;

import static ladder.domain.Point.*;

import java.util.List;

public class EdgeLine extends Line {
    public EdgeLine(final int countOfPerson) {
        super(countOfPerson);
    }

    @Override
    protected Point choiceBeforeLast(Point before) {
        return point(List.of(HORIZON, BLANK));
    }
}
