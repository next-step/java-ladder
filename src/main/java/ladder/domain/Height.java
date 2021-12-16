package ladder.domain;

import ladder.exception.HeightException;

public class Height {

    private static final String ERR_SIZE_FORMAT = "숫자를 입력해주세요";
    private static final String ERR_SIZE_MIN = "사다리 높이는 최소 1 이상입니다.";
    private static final int MIN_SIZE = 1;

    private final int size;

    private Height(String size) {
        try {
            this.size = Integer.parseInt(size);
            valid();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERR_SIZE_FORMAT);
        }
    }

    public static Height of(String size) {
        return new Height(size);
    }

    public int getSize() {
        return this.size;
    }

    private void valid() {
        if (this.size < MIN_SIZE) {
            throw new HeightException(ERR_SIZE_MIN);
        }
    }
}
