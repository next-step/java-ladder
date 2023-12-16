package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomLineGenerator;

public class Point {
    private boolean previous;
    private boolean current;


    public static Point previousOf(boolean previous) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        return new Point(previous, !previous && lineGenerator.generateLine());
    }

    public static Point previousOf(boolean previous, LineGenerator lineGenerator) {
        return new Point(previous, lineGenerator.generateLine());
    }

    public Point(boolean previous, boolean current) {
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

}
