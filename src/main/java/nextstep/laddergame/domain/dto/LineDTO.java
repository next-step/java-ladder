package nextstep.laddergame.domain.dto;

import nextstep.laddergame.domain.Line;
import nextstep.laddergame.domain.Point;

import java.util.List;

public class LineDTO {

    private List<Point> points;

    private LineDTO(List<Point> points) {
        this.points = points;
    }

    public static LineDTO from(Line line) {
        return new LineDTO(line.getPoints());
    }

    public List<Point> getPoints() {
        return points;
    }
}
