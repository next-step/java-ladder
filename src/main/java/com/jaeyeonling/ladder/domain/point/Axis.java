package com.jaeyeonling.ladder.domain.point;

public enum Axis {
    X, Y;

    boolean isX() {
        return this == X;
    }

    boolean isY() {
        return this == Y;
    }
}
