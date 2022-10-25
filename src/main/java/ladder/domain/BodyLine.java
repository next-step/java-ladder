package ladder.domain;

import static ladder.domain.Point.*;

import java.util.List;

public class BodyLine extends Line {
    public BodyLine(final int countOfPerson) {
        super(countOfPerson);
    }
    
    @Override
    protected Point choiceBeforeLast(Point before) {
        if (before == HORIZON) {
            return HORIZON;
        }
        if (before == VERTICAL_LINE) {
            return point(List.of(HORIZON, BLANK));
        }
        return BLANK;
    }
}
