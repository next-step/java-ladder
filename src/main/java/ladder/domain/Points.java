package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    public static final int SUBSTRACT_INDEX_COUNT = 2;
    private List<Point> points = new ArrayList<>();

    public Points(List<Point> points) {
        this.points = points;
    }

    public Points(List<Point> points, int countOfPerson) {
        this.points.addAll(points);

        for (int i = 0; i < getTotalPointCounts(points, countOfPerson); i++) {
            this.points.add(generateRandomPoint());
        }
    }

    public Points(int countOfPerson) {
        points.add(new Point());

        for (int i = 0; i < countOfPerson - 2; i++) {
            points.add(generateRandomPoint());
        }
    }

    private Point generateRandomPoint() {
        Point lastPoint = points.get(points.size() - 1);
        return lastPoint.exist() ? new Point(false) : new Point();
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point getPointOrNull(int index) {
        if(index >= points.size() || index < 0) return null;
        return points.get(index);
    }


    private static int getTotalPointCounts(List<Point> points, int countOfPerson) {
        if(countOfPerson  - points.size() - SUBSTRACT_INDEX_COUNT < 0){
            throw new IllegalArgumentException("요청된 points의 수가 Line을 생성하기엔 너무 큽니다.");
        }
        return countOfPerson  - points.size() - SUBSTRACT_INDEX_COUNT;
    }
}
