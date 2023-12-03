package nextstep.ladder.model;

import nextstep.ladder.model.strategy.line.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;
    private final LineStrategy lineStrategy;

    public Line(List<Point> points, LineStrategy lineStrategy) {
        this.points = points;
        this.lineStrategy = lineStrategy;
    }

    public Line generateLine() {
        List<Point> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < this.points.size(); pointIndex++) {
            drawOrStop(points, pointIndex);
        }
        return new Line(points, lineStrategy);
    }

    private void drawOrStop(List<Point> points, int pointIndex) {
        if (!this.points.get(pointIndex).equals(Point.NO_POINT)) {
            points.add(Point.NO_POINT);
            return;
        }
        if (drawOrStop(lineStrategy)) {
            points.add(Point.LEFT);
            this.points.set(pointIndex, Point.RIGHT);
            return;
        }
        points.add(Point.NO_POINT);
    }

    private boolean drawOrStop(LineStrategy lineStrategy) {
        return lineStrategy.drawLine();
    }

    public Point point(int index) {
        return this.points.get(index);
    }

    List<Point> points() {
        return this.points;
    }

    public int move(int index){
        return points.get(index).move();
    }
}
