package ladder.dto;

import ladder.domain.LadderLine;
import ladder.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class LineDto {
    private final List<Boolean> points;

    public LineDto(LadderLine ladderLine) {
        this.points = ladderLine.points()
                .stream()
                .map(Point::direction).collect(Collectors.toUnmodifiableList());

    }

    public List<Boolean> points() {
        return points;
    }
}
