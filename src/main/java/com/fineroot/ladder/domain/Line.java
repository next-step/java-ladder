package com.fineroot.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Bar> bars;

    private Line(final List<Bar> bars){
        this.bars = bars;
    }

    public static Line fromBooleanArray(Boolean... steps) {
        BarFactory barFactory = new BarFactory(steps[0]);
        List<Bar> initData = Arrays.stream(Arrays.copyOfRange(steps, 1, steps.length)).map(barFactory::next)
                .collect(Collectors.toList());
        initData.add(0,barFactory.first());
        initData.add(barFactory.last());
        return new Line(initData);
    }

    public Position move(Position position){
        return position.getFromList(bars).move().getMovement().apply(position);
    }

    @Override
    public String toString() {
        return bars.stream().map(e->"|".concat(e.toString())).collect(Collectors.joining()).stripTrailing();
    }
}
