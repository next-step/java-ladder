package com.jaeyeonling.ladder.domain.point;

import com.jaeyeonling.ladder.domain.Distance;

public enum Direction {

    LEFT(       Axis.X,         Distance.valueOf(-Direction.DEFAULT_MOVING_DISTANCE_VALUE)),
    RIGHT(      Axis.X,         Distance.valueOf(Direction.DEFAULT_MOVING_DISTANCE_VALUE)),
    STRAIGHT(   Axis.Y,         Distance.valueOf(Direction.DEFAULT_MOVING_DISTANCE_VALUE)),
    STAY(       Axis.ORIGIN,    Distance.STOP);

    public static final int DEFAULT_MOVING_DISTANCE_VALUE = 1;

    private final Axis axis;
    private final Distance distance;

    public boolean isX() {
        return axis == Axis.X;
    }
    public boolean isY() {
        return axis == Axis.Y;
    }

    Direction(final Axis axis,
              final Distance distance) {
        this.axis = axis;
        this.distance = distance;
    }
}
