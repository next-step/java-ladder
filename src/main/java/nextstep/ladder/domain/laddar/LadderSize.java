package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.exception.LadderSizeInitializeException;

public class LadderSize {
    public static final int MINIMUM_LENGTH = 1;

    private final int width;
    private final int height;

    private LadderSize(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(final int width, final int height) {
        verifySizeOfIntValue(width, height);
        return new LadderSize(width, height);
    }

    private static void verifySizeOfIntValue(final int width, final int height) {
        if (width < MINIMUM_LENGTH || height < MINIMUM_LENGTH) {
            throw new LadderSizeInitializeException(String.format("사다리 크기는 %d보다 커야 합니다.", MINIMUM_LENGTH));
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
