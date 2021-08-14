package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.HorizontalLine;
import nextstep.ladder.domain.common.Point;

public class PrintHorizontalLineDto {

    private final List<Point> points;

    public PrintHorizontalLineDto(final HorizontalLine horizontalLine) {
        this.points = horizontalLine.getPoints();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
