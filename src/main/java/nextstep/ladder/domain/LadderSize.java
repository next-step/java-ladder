package nextstep.ladder.domain;

import nextstep.ladder.exception.WrongLadderSizeException;

public class LadderSize {

    private static final int HEIGHT_MIN_SIZE = 1;
    private static final int WIDTH_MIN_SIZE = 2;

    final int width;
    final int height;


    private LadderSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(int width, int height) {
        validateLadderSize(width, height);
        return new LadderSize(width, height);
    }

    private static void validateLadderSize(int width, int height) {
        if (height < HEIGHT_MIN_SIZE || width < WIDTH_MIN_SIZE) {
            throw new WrongLadderSizeException(
                String.format("사다리의 최소 '2 X 1' 부터 생성이 가능합니다. [현재 입력: '%d x %d' ]", width, height));
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
