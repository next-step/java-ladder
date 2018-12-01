package ladder.model;

import ladder.util.LinePointGenerator;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points;

    private Line (int countOfParticipants) {
        this.points = LinePointGenerator.generate(countOfParticipants - 1);
    }

    public static Line from(int countOfParticipants) {
        return new Line(countOfParticipants);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
