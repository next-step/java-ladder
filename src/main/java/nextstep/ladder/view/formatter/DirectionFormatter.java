package nextstep.ladder.view.formatter;

import nextstep.ladder.domain.Direction;

public class DirectionFormatter implements Formatter<Direction> {

    private static final String LINE_STRING = "-----";
    private static final String EMPTY_STRING = "     ";

    @Override
    public String format(final Direction direction) {
        if (direction == Direction.RIGHT) {
            return LINE_STRING;
        }
        return EMPTY_STRING;
    }
}
