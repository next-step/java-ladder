package domain;

import utils.LadderPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final String VERTICAL_BAR = "|";
    private final int LINE_WIDTH = 5;
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return (this.points.get(position)).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        if (sizeOfPerson < 0) {
            throw new IllegalArgumentException("음수가 올 수 없습니다.");
        }
        List<Point> points = new ArrayList();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; ++i) {
            point = point.next();
            points.add(point);
        }

        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(LadderPointGenerator.generatePoint());
        points.add(point);
        return point;
    }

    public String toString() {
        return "LadderLine{points=" + this.points + '}';
    }

   /* @Override
    public String toString() {
        String line = VERTICAL_BAR;
        for (Point bool : points) {
            line += drawLine(bool) + VERTICAL_BAR;
        }
        return line;
    }

    private String drawLine(Point bool) {
        if (bool.next()) {
            return StringUtils.getReplace(StringUtils.MID_BAR, LINE_WIDTH);
        }
        return StringUtils.getReplace(StringUtils.SPACE, LINE_WIDTH);
    }*/
}
