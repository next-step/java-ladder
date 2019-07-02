package com.ladder.view.formatter;

import com.ladder.model.Point;

import static com.ladder.model.Point.POINT_RIGHT;
import static com.ladder.view.formatter.LadderFormatter.*;

public class PointFormatter implements Formatter<Point> {

    @Override
    public String format(Point point) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LADDER_OF_COLUMNS);
        if (point.equals(POINT_RIGHT)) {
            stringBuilder.append(LADDER_OF_LINE);
        } else {
            stringBuilder.append(LADDER_OF_EMPTY);
        }
        return stringBuilder.toString();
    }
}
