package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomLineGenerator;

public class LineState {
    private final boolean previous;
    private final boolean current;


    public static LineState previousOf(boolean previous) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        return new LineState(previous, !previous && lineGenerator.generateLine());
    }

    public static LineState previousOf(boolean previous, LineGenerator lineGenerator) {
        return new LineState(previous, lineGenerator.generateLine());
    }

    public LineState(boolean previous, boolean current) {
        checkForConsecutiveTrue(previous, current);
        this.previous = previous;
        this.current = current;
    }

    public boolean getPrevious() {
        return previous;
    }

    public boolean getCurrent() {
        return current;
    }

    private void checkForConsecutiveTrue(boolean previous, boolean current) {
        if (previous && current) {
            throw new IllegalArgumentException("사다리 라인은 연속으로 겹칠 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "LineState{" +
                "previous=" + previous +
                ", current=" + current +
                '}';
    }
}
