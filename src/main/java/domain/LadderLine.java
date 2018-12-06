package domain;

import javax.sound.sampled.Line;
import java.util.*;

public class LadderLine {
    private final List<Point> points;
    private int countOfPerson;

    private LadderLine(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.points = new ArrayList<>();
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public LadderLine generatePoints(LineStrategy ladderPointGenerator) {
        Point point = initFirst(ladderPointGenerator);
        point = initBody(point, ladderPointGenerator);
        initLast(point);
        return this;
    }

    public static LadderLine from(int countOfPerson) {
        return new LadderLine(countOfPerson);
    }

    private void initLast(Point point) {
        point = point.last();
        points.add(point);
    }

    private Point initBody(Point point, LineStrategy ladderPointGenerator) {
        for(int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(ladderPointGenerator);
            points.add(point);
        }
        return point;
    }

    private Point initFirst(LineStrategy levelLadderGenerator) {
        Point point = Point.first(levelLadderGenerator.generate());
        points.add(point);
        return point;
    }

   /* private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int countOfPerson, List<Point> points, Point point, LineStrategy ladderPointGenerator) {
        for(int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(ladderPointGenerator);
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points, LineStrategy levelLadderGenerator) {
        Point point = Point.first(levelLadderGenerator.generate());
        points.add(point);
        return point;
    }*/

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

    public List<Integer> trackingLine(int countOfPerson, ArrayList<Integer> tempBox) {
        ArrayList<Integer> temp = new ArrayList<>(tempBox);
        for(int i = 0; i < countOfPerson; i++) {
            tempBox.set(i, temp.get(move(i)));
        }
        return tempBox;
    }
}