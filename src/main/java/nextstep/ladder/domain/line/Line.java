package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.point.Point;

public class Line {

    private final LinePoints linePoints;

    public Line(LinePoints linePoints) {
        this.linePoints = linePoints;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.linePoints.getPoints());
    }
}
