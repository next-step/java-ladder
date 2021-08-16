package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderSizeException;

public class Height {
    private static final int ZERO = 0;
    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height of(int height) {
        heightValidate(height);
        return new Height(height);
    }

    private static void heightValidate(int height) {
        if(height <= ZERO) {
            throw new LadderSizeException("사다리 갯수는 최소 1개여야 합니다.");
        }
    }


    public int getHeight() {
        return height;
    }
}
