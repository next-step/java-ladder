package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.function.Supplier;

public class Point {

    private PointStatus status;

    public Point(PointStatus status) {
        this.status = status;
    }

    public PointStatus getStatus() {
        return status;
    }

}
