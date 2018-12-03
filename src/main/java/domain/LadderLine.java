package domain;

import java.util.*;

import static domain.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;
    private List<Integer> personsPosition = new ArrayList<>();

    private LadderLine(List<Point> points) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine from(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(countOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int countOfPerson, List<Point> points, Point point) {
        for(int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    String drawOrNot() {
        String str = "";
        for (Point ladderLine : points) {
            str += "|";
            if (ladderLine.lineDirection().isRight()) {
                str += "-----";
            }
            if (!ladderLine.lineDirection().isRight()) {
                str += "     ";
            }
        }
        return str;
    }

    private void setPosition(List<Integer> personsPosition) {
        this.personsPosition = personsPosition;
    }

    public List<Integer> getPersonsPosition() {
        return Collections.unmodifiableList(personsPosition);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public String toString() {
        return "domain.LadderLine{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine ladderLine = (LadderLine) o;
        return Objects.equals(points, ladderLine.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public List<Integer> trackingLine(List<Integer> personsPosition, ArrayList<Integer> tempBox) {
        int position = 0;
        for(Point point : points) {
            if(tempBox.isEmpty()) {
                personsPosition.set(position, point.move());
            }
            if(!tempBox.isEmpty()) {
                int num = 0;
                if (point.lineDirection().isRight()) {
                    num = 1;
                }
                if (point.lineDirection().isLeft()) {
                    num = -1;
                }
                int res = tempBox.get(position + num);
                personsPosition.set(position, res);
            }
            position++;
        }
        return personsPosition;
    }
}