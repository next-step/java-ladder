package nextstep.ladder.dto;

public class Height {

    private final int height;

    public Height(int height) {
        validatePositive(height);
        this.height = height;
    }

    private void validatePositive(int height) {
        if (!isPositive(height)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPositive(int height) {
        return height > 0;
    }

    public int height() {
        return this.height;
    }
}
