package com.seok2.ladder.structure.domain;

public class Pillar {

    private final Pillar down;
    private Rung rung;

    private Pillar(Pillar down, Pillar previous) {
        this.down = down;
        if (previous != null) {
            rung = Rung.left(previous);
            previous.rung = Rung.right(this);
        }
    }

    public static Pillar of() {
        return new Pillar(null, null);
    }

    protected boolean isLung() {
        return rung != null;
    }

    public Pillar build(Pillar previous, BuildStrategy strategy) {
        if (previous == null || previous.isLung()) {
            return new Pillar(this, null);
        }
        return new Pillar(this, strategy.apply(previous));
    }

    public Rung getRung() {
        return rung;
    }

    protected Pillar down() {
        if (down == null) {
            return this;
        }
        return this.down;
    }

    public Pillar next() {
        if (isLung()) {
            return rung.move();
        }
        return down;
    }

    public boolean isNotBottom() {
        return down != null;
    }
}
