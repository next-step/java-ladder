package nextstep.domain.line;

import nextstep.generator.LineGenerator;

public class Point {
    private final boolean point;

    public Point(LineGenerator lineGenerator) {
        this.point = lineGenerator.generate();
    }

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isConnected() {
        return point;
    }
}
