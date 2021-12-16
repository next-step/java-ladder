package nextstep.ladder.domain;

/**
 * @author han
 */
public class Height {

    private static final int MINIMUM_SIZE = 1;

    private final int height;

    public Height(int height) {
        validSize(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validSize(int height) {
        if (height < MINIMUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
