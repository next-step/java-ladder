package nextstep.ladder.domain;

public class MockRungStrategy implements RungStrategy {

    private int applyCallCount = 0;

    @Override
    public void apply(Junction curr, Junction right) {
        applyCallCount++;
    }

    public int getApplyCallCount() {
        return applyCallCount;
    }
}
