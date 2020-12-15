package ladder.dto;

import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.PointStatus;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderDTO {

    private final List<Line> layout;

    public LadderDTO(List<Line> layout) {
        this.layout = layout;
    }

    public List<List<Boolean>> getLayout() {
        return this.layout.stream()
                .map(Line::getValidPoints)
                .map(points -> points.stream()
                        .map(Point::getPointStatus)
                        .map(PointStatus::getStatus)
                        .collect(toList()))
                .collect(toList());
    }
}
