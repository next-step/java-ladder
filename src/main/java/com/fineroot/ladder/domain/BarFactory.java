package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class BarFactory {

    private BarFactory(){
        throw new IllegalArgumentException(ExceptionMessage.UTILITY_CLASS.getMessage());
    }

    public static List<Bar> createBars(Boolean... steps){
        List<Bar> result = new ArrayList<>();
        for (int i = 0; i < steps.length + 1; i++) {
            result.add(createBar(result,steps));
        }
        return result;
    }

    private static Bar createBar(List<Bar> bars, Boolean... steps) {
        if (bars.isEmpty()) {
            return Bar.of(false, steps[0]);
        }

        if (bars.size() - 1 == steps.length) {
            return Bar.of(steps[steps.length - 1], false);
        }

        return createNextBar(bars, steps);
    }

    private static Bar createNextBar(List<Bar> bars, Boolean... steps) {
        if (!bars.get(bars.size() - 1).currentStep()) {
            return Bar.of(bars.get(bars.size() - 1).currentStep(), steps[bars.size()]);
        }
        return Bar.of(bars.get(bars.size() - 1).currentStep(), false);
    }
}
