package com.jaeyeonling.ladder.domain.point;

public enum Direction {

    LEFT(Axis.X, Distance.valueOf(-Direction.DEFAULT_MOVING_DISTANCE_VALUE)),
    RIGHT(Axis.X, Distance.valueOf(Direction.DEFAULT_MOVING_DISTANCE_VALUE)),
    STRAIGHT(Axis.Y, Distance.valueOf(Direction.DEFAULT_MOVING_DISTANCE_VALUE));

    public static final int DEFAULT_MOVING_DISTANCE_VALUE = 1;

    private final Axis axis;
    private final Distance distance;

    Direction(final Axis axis,
              final Distance distance) {
        this.axis = axis;
        this.distance = distance;
    }

    public boolean isX() {
        return axis == Axis.X;
    }

    public boolean isY() {
        return axis == Axis.Y;
    }

    public Distance getDistance() {
        return distance;
    }
}
