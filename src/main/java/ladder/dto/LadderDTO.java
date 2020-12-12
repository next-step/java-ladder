package ladder.dto;

import ladder.domain.HorizontalLine;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.PointStatus;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderDTO {

    private final List<Line> layout1;
    private List<HorizontalLine> layout;

    public LadderDTO(List<?> layout) {
        if (layout.get(0) instanceof HorizontalLine) {
            this.layout = (List<HorizontalLine>) layout;
        }
        this.layout1 = (List<Line>) layout;
    }

    public List<List<Boolean>> getLayout() {
        return this.layout.stream()
                .map(HorizontalLine::getLine)
                .collect(toList());
    }

    public List<List<Boolean>> getLayout1() {
        return this.layout1.stream()
                .map(Line::getPoints)
                .map(points -> points.stream()
                        .map(Point::getPointStatus)
                        .map(PointStatus::getStatus)
                        .collect(toList()))
                .collect(toList());
    }
}
