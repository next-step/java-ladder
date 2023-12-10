package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Bar;
import com.fineroot.ladder.engine.Line;
import com.fineroot.ladder.engine.LineCreator;
import java.util.ArrayList;
import java.util.List;

public class MyLineCreator implements LineCreator {

    private final MyBarCreator myBarCreator;

    public MyLineCreator(MyBarCreator myBarCreator) {
        this.myBarCreator = myBarCreator;
    }

    @Override
    public Line create(Boolean... steps) {
        return new MyLine(createBars(steps));
    }

    private List<Bar> createBars(Boolean... steps){
        List<Bar> result = new ArrayList<>();
        for (int i = 0; i < steps.length + 1; i++) {
            result.add(createBar(result,steps));
        }
        return result;
    }

    private Bar createBar(List<Bar> bars, Boolean... steps) {
        if (bars.isEmpty()) {
            return myBarCreator.create(false, steps[0]);
        }

        if (bars.size() == steps.length) {
            return myBarCreator.create(steps[steps.length - 1], false);
        }

        return createNextBar(bars, steps);
    }

    private Bar createNextBar(List<Bar> bars, Boolean... steps) {
        if (!bars.get(bars.size() - 1).currentStep()) {
            return myBarCreator.create(bars.get(bars.size() - 1).currentStep(), steps[bars.size()]);
        }
        return myBarCreator.create(bars.get(bars.size() - 1).currentStep(), false);
    }
}
