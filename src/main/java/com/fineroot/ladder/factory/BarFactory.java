package com.fineroot.ladder.factory;

import com.fineroot.ladder.domain.MyBar;
import com.fineroot.ladder.engine.Bar;
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
            return MyBar.of(false, steps[0]);
        }

        if (bars.size() == steps.length) {
            return MyBar.of(steps[steps.length - 1], false);
        }

        return createNextBar(bars, steps);
    }

    private static Bar createNextBar(List<Bar> bars, Boolean... steps) {
        if (!bars.get(bars.size() - 1).currentStep()) {
            return MyBar.of(bars.get(bars.size() - 1).currentStep(), steps[bars.size()]);
        }
        return MyBar.of(bars.get(bars.size() - 1).currentStep(), false);
    }
}
