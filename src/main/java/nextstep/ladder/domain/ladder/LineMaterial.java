package nextstep.ladder.domain.ladder;

public class LineMaterial {
    private static final int FIRST_AND_MIDDLE_POINT_SIZE = 2;

    private final int sizeOfPoint;
    private final DirectionStrategy directionStrategy;

    public static LineMaterial of(final int sizeOfPoint, final DirectionStrategy directionStrategy) {
        return new LineMaterial(sizeOfPoint, directionStrategy);
    }

    private LineMaterial(final int sizeOfPoint, final DirectionStrategy directionStrategy) {
        if (sizeOfPoint < 1) {
            throw new IllegalArgumentException(String.format("Point 수는 1 이상의 양의 정수만 가능합니다 (%d)", sizeOfPoint));
        }
        this.sizeOfPoint = sizeOfPoint;
        this.directionStrategy = directionStrategy;
    }

    int getSizeOfMiddlePoints() {
        if (sizeOfPoint > FIRST_AND_MIDDLE_POINT_SIZE) {
            return sizeOfPoint - FIRST_AND_MIDDLE_POINT_SIZE;
        }
        return 0;
    }

    DirectionStrategy getDirectionStrategy() {
        return directionStrategy;
    }
}
