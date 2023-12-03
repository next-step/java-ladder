package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Bar> bars = new ArrayList<>();

    private Line(final int countOfUser) {
        BarFactory barFactory = new BarFactory(RandomUtils.getBoolean());
        bars.add(barFactory.first());
        for (int i = 0; i < countOfUser - 2; i++) {
            bars.add(barFactory.next(RandomUtils.getBoolean()));
        }
        bars.add(barFactory.last());
    }

    private Line(final Boolean ... steps){
        BarFactory barFactory = new BarFactory(steps[0]);
        bars.add(barFactory.first());
        for (int i = 0; i < steps.length-1; i++) {
            bars.add(barFactory.next(steps[i+1]));
        }
        bars.add(barFactory.last());
    }

    public static Line from(Users users) {
        return new Line(users.size());
    }

    public static Line fromBooleanArray(Boolean... steps) {
        return new Line(steps);
    }

    @Override
    public String toString() {
        return bars.stream().map(e->"|".concat(e.toString())).collect(Collectors.joining()).stripTrailing();
    }
}
