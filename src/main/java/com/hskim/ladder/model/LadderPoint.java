package com.hskim.ladder.model;

import java.util.Objects;

public class LadderPoint {

    private Point leftPoint;
    private Point currentPoint;
    private Point rightPoint;

    public LadderPoint(Point leftPoint, Point currentPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.currentPoint = currentPoint;
        this.rightPoint = rightPoint;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public boolean isColumn() {
        return currentPoint == Point.COLUMN;
    }

    public boolean isLeftDirection() {
        return leftPoint == Point.ROW;
    }

    public boolean isRightDirection() {
        return rightPoint == Point.ROW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderPoint)) return false;
        LadderPoint that = (LadderPoint) o;
        return leftPoint == that.leftPoint &&
                currentPoint == that.currentPoint &&
                rightPoint == that.rightPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftPoint, currentPoint, rightPoint);
    }
}
