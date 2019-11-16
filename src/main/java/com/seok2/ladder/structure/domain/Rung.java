package com.seok2.ladder.structure.domain;

public class Rung {

    private final Direction direction;
    private final Pillar pillar;

    private Rung(Direction direction, Pillar pillar) {
        this.direction = direction;
        this.pillar = pillar;
    }

    public static Rung left(Pillar pillar) {
        return new Rung(Direction.LEFT, pillar);
    }

    public static Rung right(Pillar pillar) {
        return new Rung(Direction.RIGHT, pillar);
    }


    public Pillar move() {
        return pillar.down();
    }

    public boolean isLeft() {
        return direction.equals(Direction.LEFT);
    }

    public boolean isRight() {
        return !isLeft();
    }
}
