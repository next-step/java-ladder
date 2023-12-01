package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Bar> bars = new ArrayList<>();

    private Line(final int countOfUser) {
        initSteps();
        for (int i = 0; i < countOfUser - 2; i++) {
            addStep(i);
        }
        addLastStep();
    }


    private Line(final Boolean ... steps){
        bars.add(Bar.of(false, steps[0]));
        for (int i = 0; i < steps.length-1; i++) {
            bars.add(Bar.of(bars.get(i).currentStep(),steps[i+1]));
        }
        bars.add(Bar.of(bars.get(bars.size()-1).currentStep(), false));
    }

    private void initSteps() {
        bars.add(Bar.of(false, RandomUtils.getBoolean()));
    }


    private void addStep(int index) {
        bars.add(createBar(bars.get(index)));
    }

    private Bar createBar(Bar bar) {
        if(!bar.currentStep()){
            return Bar.of(bar.currentStep(), RandomUtils.getBoolean());
        }
        return Bar.of(bar.currentStep(), false);
    }

    private void addLastStep() {
        bars.add(Bar.of(bars.get(bars.size()-1).currentStep(),false));
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
