package ladder.domain.ladder;

public class Height {

    static final int MINIMUM_HEIGHT = 1;

    private final int value;

    Height(final int value) {
        validateHeightIsNotLessThanMinimum(value);

        this.value = value;
    }

    int value() {
        return this.value;
    }

    private void validateHeightIsNotLessThanMinimum(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리는 최소 높이보다 작을 수 없습니다. 높이: " + height);
        }
    }
}
