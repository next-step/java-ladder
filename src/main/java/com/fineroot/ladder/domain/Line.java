package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Step> steps = new ArrayList<>();
    private final int stepSize;

    private Line(final int countOfUser, final int stepSize) {
        this.stepSize = stepSize;
        initSteps();
        for (int i = 0; i < countOfUser - 2; i++) {
            addStep(i);
        }
        addLastStep();
    }


    private Line(final Boolean ... steps){
        stepSize = 5;
        this.steps.add(Step.from(Bar.first(steps[0])));
        for (int i = 0; i < steps.length-1; i++) {
            this.steps.add(Step.from(this.steps.get(i).next(steps[i+1])));
        }
        this.steps.add(Step.from(this.steps.get(this.steps.size()-1).last()));
    }

    private void initSteps() {
        steps.add(Step.from(Bar.first(RandomUtils.getBoolean())));
    }

    private void addStep(int index) {
        steps.add(getStep(steps.get(index)));
    }

    private Step getStep(Step step) {
        if(step.canNextTrue()){
            return Step.from(step.next(RandomUtils.getBoolean()));
        }
        return Step.from(step.next(false));
    }

    private void addLastStep() {
        steps.add(Step.from(steps.get(steps.size()-1).last()));
    }

    public static Line from(Users users) {
        return new Line(users.size(),users.longestUserNameLength());
    }

    public static Line fromBooleanArray(Boolean... steps) {
        return new Line(steps);
    }

    @Override
    public String toString() {
        return steps.stream().map(e->"|".concat(e.toString().repeat(stepSize))).collect(Collectors.joining()).stripTrailing();
    }
}
