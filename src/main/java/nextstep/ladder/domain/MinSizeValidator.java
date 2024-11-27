package nextstep.ladder.domain;

public class MinSizeValidator {
    private static final int MIN_WIDTH = 2;

    public void valid(int size) {
        if (size < MIN_WIDTH) {
            throw new IllegalArgumentException("다리의 길이는 2이상이여야한다");
        }
    }
}
