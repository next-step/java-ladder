package ladder.domain;

import static ladder.domain.Point.*;

import java.util.List;

public class EdgeLine extends Line {
    public EdgeLine(final int countOfPerson) {
        super(countOfPerson);
    }

    @Override
    protected Point choiceBeforeLast(final Point before) {
        return choicePoint(List.of(HORIZON, BLANK));
    }
}
