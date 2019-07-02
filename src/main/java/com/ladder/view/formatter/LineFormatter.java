package com.ladder.view.formatter;

import com.ladder.model.Line;
import com.ladder.model.Point;

import static com.ladder.view.formatter.LadderFormatter.LADDER_OF_EMPTY;
import static com.ladder.view.formatter.LadderFormatter.LADDER_OF_FINISH;

public class LineFormatter implements Formatter<Line> {

    private final Formatter<Point> pointFormatter = new PointFormatter();

    @Override
    public String format(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LADDER_OF_EMPTY);

        line.getPoints().stream()
                .map(pointFormatter::format)
                .forEach(stringBuilder::append);

        stringBuilder.append(LADDER_OF_FINISH);
        return stringBuilder.toString();
    }
}
