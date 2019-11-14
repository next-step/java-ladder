package com.seok2.ladder.structure.domain;

public class Line {

    private final Line down;
    private Rung rung;

    private Line(Line down, Line side) {
        this.down = down;
        if (side != null) {
            rung = Rung.right(side);
            side.rung = Rung.left(this);
        }
    }

    protected static Line of() {
        return new Line(null, null);
    }

    protected boolean isLung() {
        return rung != null;
    }

    protected Line build(Line previous, BuildStrategy strategy) {
        if (previous == null || previous.isLung()) {
            return new Line(this, null);
        }
        return new Line(this, strategy.apply(previous));
    }

    public Rung getRung() {
        return rung;
    }

    protected Line down() {
        return this.down;
    }

    protected Line next() {
        if(isLung())
            return rung.move();
        return down;
    }
}
