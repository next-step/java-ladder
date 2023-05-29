package nextstep.ladder;

import java.util.Collections;
import java.util.Objects;

import nextstep.ladder.drawPolicy.DrawablePolicy;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final List<Point> points;
    private final DrawablePolicy randomDraw;

    public LadderRow(int personCount, DrawablePolicy randomDraw) {
        this.randomDraw = randomDraw;

        if (personCount == 0) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람은 0명이 될 수 없습니다.");
        }

        points = new ArrayList<>();
        Point currentPoint = Point.createInstance(randomDraw);
        points.add(currentPoint);

        for (int i = 1; i < personCount; i++) {
            currentPoint = createPoint(i, personCount, currentPoint);
            points.add(currentPoint);
        }
    }

    private Point createPoint(int index, int lastIndex, Point currentPoint) {
        if (index == lastIndex - 1) {
            return Point.lastInstance(currentPoint);
        }
        return Point.createInstance(currentPoint, randomDraw);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int movedPointIndex(int currentIndex){
        return points.get(currentIndex)
                .calculateMovedIndex(currentIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderRow ladderRow = (LadderRow) o;
        return Objects.equals(points, ladderRow.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
