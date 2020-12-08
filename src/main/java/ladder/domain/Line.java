package ladder.domain;

import java.util.*;

public class Line {

    private final List<Point> points;

    public Line (int countOfPerson) {
        this.points = generateLine(countOfPerson);
    }

    public Line (List<Point> points) {
        this.points = points;
    }

    private static List<Point> generateLine(int countOfPerson) {
        LinkedList<Point> pointsList = new LinkedList<>();

        Point prePoint = Point.first(nextBooleanStrategy());
        pointsList.addFirst(prePoint);

        for (int i = 1; i < countOfPerson - 1; i++) {
            prePoint = Point.next(prePoint, nextBooleanStrategy());
            pointsList.add(prePoint);
        }

        pointsList.addLast(Point.last(prePoint));
        return pointsList;
    }

    private static NextBooleanRule nextBooleanStrategy() {
        return new NextBoolean();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int movePoint(int position) {
        Pointer pointer = this.points.get(position).getPointer();

        if (pointer.isRight()) {
            return position + 1;
        }

        if (pointer.isLeft()) {
            return position - 1;
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
