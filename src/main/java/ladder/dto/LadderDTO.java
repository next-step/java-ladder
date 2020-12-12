package ladder.dto;

import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.PointStatus;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderDTO {

    private final List<Line> layout1;

    public LadderDTO(List<Line> layout) {
        this.layout1 = layout;
    }

    public List<List<Boolean>> getLayout1() {
        return this.layout1.stream()
                .map(Line::getValidPoints)
                .map(points -> points.stream()
                        .map(Point::getPointStatus)
                        .map(PointStatus::getStatus)
                        .collect(toList()))
                .collect(toList());
    }
}
