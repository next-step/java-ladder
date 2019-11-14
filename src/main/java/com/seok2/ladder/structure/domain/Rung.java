package com.seok2.ladder.structure.domain;

public class Rung {

    private final Direction direction;
    private final Line line;

    private Rung(Direction direction, Line line) {
        this.direction = direction;
        this.line = line;
    }

    public static Rung left(Line line) {
        return new Rung(Direction.LEFT, line);
    }

    public static Rung right(Line line) {
        return new Rung(Direction.RIGHT, line);
    }


    public Line move() {
        return line.down();
    }

    public boolean isLeft() {
        return direction.equals(Direction.LEFT);
    }

    public boolean isRight() {
        return !isLeft();
    }
}
