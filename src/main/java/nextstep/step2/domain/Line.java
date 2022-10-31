package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    private Line(final int countOfParticipant){
        for (int i = 0; i < countOfParticipant; i++) {
            RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
            points.add(Point.from(randomLineGenerator.createRandomBoolean()));
        }
    }

    public static Line from(final int countOfParticipant){
        return new Line(countOfParticipant);
    }

    public List<Point> getPoints() {
        return points;
    }
}
