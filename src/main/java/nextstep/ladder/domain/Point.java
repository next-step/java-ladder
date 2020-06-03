package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.PointStrategy;

public class Point {

    private final boolean hasPoint;

    private Point(boolean hasPoint) {
        this.hasPoint = hasPoint;
    }

    public static Point newInstance(boolean hasPoint) {
        return new Point(hasPoint);
    }

    public static Point first(PointStrategy pointStrategy) {
        validateStrategy(pointStrategy);
        return new Point(pointStrategy.generatePoint());
    }

    public Point next(PointStrategy pointStrategy) {
        validateStrategy(pointStrategy);
        return this.hasPoint ? Point.newInstance(false) : Point.newInstance(pointStrategy.generatePoint());
    }

    private static void validateStrategy(PointStrategy pointStrategy) {
        if (pointStrategy == null) {
            throw new IllegalArgumentException("생성 전략이 존재하지 않습니다.");
        }
    }

    public void validate(Point prevPoint) {
        if (!this.hasPoint) {
            return;
        }

        if (prevPoint.hasPoint) {
            throw new IllegalArgumentException("가로 라인이 겹칩니다.");
        }
    }

    public boolean hasPoint() {
        return this.hasPoint;
    }
}
