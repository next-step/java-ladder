package nextstep.ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private int point;

    public Height(int point) {
        validateHeight(point);
        this.point = point;
    }

    private void validateHeight(int point) {
        if (point < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 최소 %d 이상이어야 합니다.", MIN_HEIGHT));
        }
    }

    public int getPoint() {
        return point;
    }
}
