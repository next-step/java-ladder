package com.seok2.ladder.structure.domain;

public class Line {

    protected final Line down;
    protected Line link;
    protected boolean rung = false;

    private Line(Line down, Line side) {
        this.down = down;
        this.link = side;
        if(link != null) {
            side.rung = true;
            side.link = this;
        }
    }

    protected static Line of() {
        return new Line(null, null);
    }

    protected boolean isLink() {
        return link != null;
    }

    protected Line build(Line previous, BuildStrategy strategy) {
        if(previous == null || previous.isLink())
            return new Line(this, null);
        return new Line(this, strategy.apply(previous));
    }
}
