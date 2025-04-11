package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsers;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private final PointFactory pointFactory;

    public LineFactory() {
        this(new PointFactory());
    }

    public LineFactory(PointFactory pointFactory) {
        this.pointFactory = pointFactory;
    }

    public Line create(LadderUsers ladderUsers) {
        List<Point> points = new ArrayList<>();
        Point previousPoint = pointFactory.create(new Point(false));
        points.add(previousPoint);

        for (int i = 1; i < ladderUsers.getSize() - 1; i++) {
            Point newPoint = pointFactory.create(previousPoint);
            points.add(newPoint);
            previousPoint = newPoint;
        }

        return new Line(points);
    }
}
