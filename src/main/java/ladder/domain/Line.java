package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line valueOf(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        boolean point = false;
        while (countOfPerson > 0 ){
            points.add(Point.of(point));
            point = checkLineOverlap(point, random);
            countOfPerson --;
        }
        return new Line(points);
    }

    static boolean checkLineOverlap(Boolean point, Random random) {
        if (point) {
            return false;
        }
        return random.nextBoolean();
    }

    public List<Point> getPoints() {
        return points;
    }
}
