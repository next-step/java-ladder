package step3_renewal.domain;


import step3_renewal.utils.LadderUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson, LadderUtil ladderUtil) {
        List<Point> points = new ArrayList<>();
        points.add(createLadderLine(sizeOfPerson, points, ladderUtil.isLine()));
        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private static Point createLadderLine(int sizeOfPerson, List<Point> points, boolean isLine) {
        Point point = Point.first(isLine);
        points.add(point);

        for (int i = 1; i < sizeOfPerson - 1; i++) {
            isLine = nextCreate(isLine);
            point = point.next(isLine);
            points.add(point);
        }
        points.add(point.last());

        return point;
    }

    private static boolean nextCreate(boolean isLine) {
        LadderUtil ladderUtil = new LadderUtil();
        boolean isNextLine = ladderUtil.isLine();
        if (isLine && isNextLine) {
            return false;
        }
        return isNextLine;
    }

    public List<Point> getPoints() {
        return points;
    }
}
