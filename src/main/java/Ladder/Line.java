package Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int BEGIN_POINT = 0;
    private static final int BEFORE_COUNT = 1;
    private static final Boolean LINEAR = true;
    private static final Boolean BLANK = false;
    private List<Point> points = new ArrayList<>();
    private int count;

    public Line(int countOfPerson) {
        this.count = countOfPerson;

    }

    public void initLine() {
        for (int i = 0; i < count - BEFORE_COUNT; i++) {
            points.add(calculatePoint(i));
        }
    }

    public Point calculatePoint(int count) {
        if (count == BEGIN_POINT) {
            return new PointGenerator().getRandomBoolean();
        }
        //이전이 직선인지 아닌지 확인!
        if (validationCheck(points)) {
            return Point.of(BLANK);
        }
        return new PointGenerator().getRandomBoolean();

    }

    public Boolean validationCheck(List<Point> points) {
        return points.get(points.size() - BEFORE_COUNT).equals(Point.of(LINEAR));
    }

    @Override
    public String toString() {
        StringBuilder lineString = new StringBuilder();
        lineString.append("    |");
        points.stream().forEach(point -> lineString.append(point.toString()));
        return lineString.toString();
    }

    public int decideDestination(int position) {
        if (position != BEGIN_POINT && position != points.size()) {
            position = compareMiddleLine(position - BEFORE_COUNT, position);
        }

        if (position == BEGIN_POINT && points.get(position).equals(Point.of(LINEAR))) {
             position+=1;

        }
        if (position == points.size() && points.get(position - 1).equals(Point.of(LINEAR))) {

             position-=1;

        }
        return position;
    }

    public int compareMiddleLine(int beforePosition, int position) {
        if (points.get(beforePosition).equals(Point.of(LINEAR))) {
            position-=1;
        }
        if (points.get(position).equals(Point.of(LINEAR))) {
            position+=1;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return count == line.count &&
                Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, count);
    }
}



