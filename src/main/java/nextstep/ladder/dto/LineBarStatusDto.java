package nextstep.ladder.dto;

import nextstep.ladder.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class LineBarStatusDto {

    private final List<Boolean> barStatus;

    public LineBarStatusDto(final List<Point> points) {
        this.barStatus = points.stream()
                .map(Point::isRightDirection)
                .limit(points.size() - 1)
                .collect(Collectors.toList());
    }

    public List<Boolean> getBarStatus() {
        return barStatus;
    }

    public boolean isSizeOver(final int number) {
        return barStatus.size() > number;
    }

}
