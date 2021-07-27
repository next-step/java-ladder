package nextstep.ladder.domain.init;

public class LadderSize {
    protected static final int MINIMUM_LENGTH = 1;

    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        validate(width, height);

        this.width = width;
        this.height = height;
    }

    private void validate(int width, int height) {
        if (width < MINIMUM_LENGTH || height < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("Ladder size can't be under " + MINIMUM_LENGTH);
        }
    }

    public static LadderSize of(int width, int height) {
        return new LadderSize(width, height);
    }
}
