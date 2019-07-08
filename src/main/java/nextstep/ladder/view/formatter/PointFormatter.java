package nextstep.ladder.view.formatter;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;

public class PointFormatter implements Formatter<Point> {
    private static final String POINT_STRING = "|";

    private final Formatter<Direction> directionFormatter;

    public PointFormatter(final Formatter<Direction> directionFormatter) {
        this.directionFormatter = directionFormatter;
    }

    @Override
    public String format(final Point point) {
        return POINT_STRING + directionFormatter.format(point.getDirection());
    }
}
