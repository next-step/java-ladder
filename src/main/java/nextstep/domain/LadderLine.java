package nextstep.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;
    private final List<Boolean> visitedList;

    public LadderLine(List<Point> points, List<Boolean> visitedList) {
        this.points = points;
        this.visitedList = visitedList;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int moves(int position) {
        int result = position;
        while(!isStop(result)) {
            result = move(result);
            visitedList.set(result, true);
        }
        int visitedListSize = visitedList.size();
        for(int i = 0; i<visitedListSize; i++) {
            visitedList.set(i,false);
        }

        return result;
    }

    private boolean isStop(int position) {
        return visitedList.get(position);
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        List<Boolean> visitedList = new ArrayList<>();
        Point point = initFirst(points, visitedList);
        point = initBody(sizeOfPerson, points, point, visitedList);
        initLast(points, point, visitedList);
        return new LadderLine(points, visitedList);
    }

    private static void initLast(List<Point> points, Point point, List<Boolean> visitedList) {
        point = point.last();
        points.add(point);
        visitedList.add(false);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, List<Boolean> visitedList) {
        for(int i = 1; i< sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
            visitedList.add(false);
        }
        return point;
    }

    private static Point initFirst(List<Point> points, List<Boolean> visitedList) {
        Point point = Point.first(LadderLineGenerator.generatePoint());
        points.add(point);
        visitedList.add(false);
        return point;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
