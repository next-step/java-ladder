package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points = new ArrayList<>();

    private Line(final int countOfParticipant){
        IntStream.range(0, countOfParticipant)
                .forEach(i -> points.add(Point.from(RandomLineGenerator.getRandomBoolean())));
    }

    public static Line from(final int countOfParticipant){
        return new Line(countOfParticipant);
    }

    public List<Point> getPoints() {
        return points;
    }
}
