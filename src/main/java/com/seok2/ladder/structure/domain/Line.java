package com.seok2.ladder.structure.domain;

public class Line {

    private final Line down;
    private Rung rung;

    private Line(Line down, Line previous) {
        this.down = down;
        if (previous != null) {
            rung = Rung.left(previous);
            previous.rung = Rung.right(this);
        }
    }

    public static Line of() {
        return new Line(null, null);
    }

    protected boolean isLung() {
        return rung != null;
    }

    public Line build(Line previous, BuildStrategy strategy) {
        if (previous == null || previous.isLung()) {
            return new Line(this, null);
        }
        return new Line(this, strategy.apply(previous));
    }

    public Rung getRung() {
        return rung;
    }

    protected Line down() {
        if (down == null) {
            return this;
        }
        return this.down;
    }

    public Line next() {
        if (isLung()) {
            return rung.move();
        }
        return down;
    }

    public boolean isNotBottom() {
        return down != null;
    }
}
