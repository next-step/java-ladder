package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public Lines getLines(Members members) {
        List<Line> lines = IntStream.range(0, this.maxHeightOfLadder)
                .mapToObj(i -> new Line(members))
                .collect(Collectors.toList());

        return new Lines(lines);
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
