package nextstep.step3.domain.strategy;

import java.util.List;

public class TestDrawLineStrategy implements DrawLineStrategy {
    List<Boolean> testPoints;

    public TestDrawLineStrategy(List<Boolean> testPoints) {
        this.testPoints = testPoints;
    }

    @Override
    public boolean isDrawLine(List<Boolean> points, int idx) {
        return testPoints.get(idx);
    }
}
