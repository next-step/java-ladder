package com.fineroot.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Bar> bars;

    private Line(final List<Bar> bars){
        this.bars = bars;
    }

    public static Line fromBooleanArray(Boolean... steps) {
        return new Line(BarFactory.createBars(steps));
    }

    public Position move(Position position){
        return position.getFromList(bars).move(position);
    }

    @Override
    public String toString() {
        return bars.stream().map(Bar::toString).collect(Collectors.joining()).stripTrailing();
    }
}
