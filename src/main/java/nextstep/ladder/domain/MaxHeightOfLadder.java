package nextstep.ladder.domain;

public class MaxHeightOfLadder {
    private static final int MIN = 1;

    private final int maxHeightOfLadder;

    public MaxHeightOfLadder(String string) {
        this(toInt(string));
    }

    MaxHeightOfLadder(int maxHeightOfLadder) {
        checkLessThenMin(maxHeightOfLadder);
        this.maxHeightOfLadder = maxHeightOfLadder;
    }

    private static int toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NotNumberStringIsNotAllowException();
        }
    }

    private void checkLessThenMin(int maxHeightOfLadder) {
        if (maxHeightOfLadder < MIN) {
            throw new NotAllowNegativeOrZero();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.maxHeightOfLadder);
    }

    public static class NotNumberStringIsNotAllowException extends IllegalArgumentException {
        public NotNumberStringIsNotAllowException() {
            super("숫자가 아닌 문자열은 허용되지 않습니다.");
        }
    }

    public static class NotAllowNegativeOrZero extends IllegalArgumentException {
        public NotAllowNegativeOrZero() {
            super("음수이거나 0은 허용되지 않은 값입니다.");
        }
    }
}
