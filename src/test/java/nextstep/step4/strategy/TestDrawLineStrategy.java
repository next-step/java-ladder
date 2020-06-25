package nextstep.step4.strategy;

import nextstep.step4.domain.strategy.DrawLineStrategy;

import java.util.List;

public class TestDrawLineStrategy implements DrawLineStrategy {
    private List<Boolean> testPoints;
    private int index = 0;

    public TestDrawLineStrategy(List<Boolean> testPoints) {
        this.testPoints = testPoints;
    }

    @Override
    public boolean isDrawLine() {
        return getTestData();
    }

    private boolean getTestData() {
        if(index == testPoints.size()) {
            index = 0;
        }
        boolean result = testPoints.get(index);
        index += 1;
        return result;
    }

}
