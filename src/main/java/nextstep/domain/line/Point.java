package nextstep.domain.line;

import nextstep.generator.RandomNumberGenerator;

public class Point {
    private final boolean point;

    public Point(RandomNumberGenerator randomNumberGenerator) {
        this.point = randomNumberGenerator.generate();
    }

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isConnected() {
        return point;
    }
}
