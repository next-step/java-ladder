package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Point> points;

    public Line(int pointSize) {
        this.points = createPoints(pointSize);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private List<Point> createPoints(int pointSize) {
        List<Point> points = new ArrayList<>();
        for (int index = 0; index < pointSize; index++) {
            addPoint(points, index, pointSize);
        }
        return points;
    }

    private void addPoint(List<Point> points, int index, int pointSize) {
        int totalSizeBound = PointStatus.TOTAL_INDEX_SIZE;
        int twoResultSizeBound = PointStatus.TWO_RESULT_SIZE;
        if (index == 0) {
            points.add(Point.createFirst(() -> RandomUtil.generator(twoResultSizeBound)));
            return;
        }
        if (pointSize - 1 == index) {
            points.add(Point.createLast(() -> RandomUtil.generator(twoResultSizeBound), points.get(index - 1)));
            return;
        }
        Point point = Point.create(() -> RandomUtil.generator(totalSizeBound), points.get(index - 1));
        // LEFT 일때 points list 값 바꾸기
        points.add(point);
    }

}
