package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Point> points;

    public Line(int countOfPerson) {
        this.points = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean canDraw = (i == 0 || !points.get(i - 1).hasRight()); // 이전이 true면 이번엔 false
            points.add(new Point(canDraw && random.nextBoolean()));
        }
    }

    public List<Point> points() {
        return points;
    }

}
