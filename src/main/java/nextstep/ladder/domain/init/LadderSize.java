package nextstep.ladder.domain.init;

public class LadderSize {

    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(int width, int height) {
        return new LadderSize(width, height);
    }
}
