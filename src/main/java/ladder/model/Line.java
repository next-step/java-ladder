package ladder.model;

import ladder.utils.StatusGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints(){
        return Collections.unmodifiableList(points);
    }

    public static Line lineSet(int countOfPerson) {
        int lastIndex = validMinUserCount(countOfPerson);

        List<Point> points = createBody(lastIndex, createFirst());
        points.add(createLast(points.get(lastIndex - 1)));
        return new Line(points);
    }

    private static Point createFirst() {
        Point point = Point.first(StatusGenerator.get());
        return point;
    }

    private static List<Point> createBody(int lastIndex, Point firstPoint) {
        List<Point> points = new ArrayList <>();
        points.add(firstPoint);

        for(int i = 1; i < lastIndex; i++){
            firstPoint = firstPoint.next();
            points.add(firstPoint);
        }
        return points;
    }

    private static Point createLast(Point point) {
        return point.last();
    }

    private static int validMinUserCount(int countOfPerson){
        if(countOfPerson < 2){
            throw new IllegalStateException("사다리 게임 참여자는 최소 2명 이상이어야 합니다.");
        }
        return countOfPerson - 1;
    }

}
