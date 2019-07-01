package com.jaeyeonling.ladder.domain.point;

public enum Axis {
    X, Y, ORIGIN;

    boolean isX() {
        return this == X;
    }

    boolean isY() {
        return this == Y;
    }
}
