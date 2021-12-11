package ladder.domain;

import java.util.List;
import java.util.regex.Pattern;

public class Position {
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 숫자가 아닌 값이 있습니다.";
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final int LINE_EXIST = 1;
    private static final int LINE_NONE = 0;
    private static final int FIRST_LINE_POSITION = 0;

    private final int position;

    private Position(int position) {
        validNumber(position);
        this.position = position;
    }

    private void validNumber(int number) {
        if (!Pattern.matches(NUMBER_PATTERN, String.valueOf(number))) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

    public static Position move(int position, List<Integer> line) {
        return new Position(position - left(position, line) + right(position, line));
    }

    public static int left(int position, List<Integer> line) {
        if (position != FIRST_LINE_POSITION) {
            return lineExist(line.get(position - 1));
        }
        return LINE_NONE;
    }

    public static int right(int position, List<Integer> line) {
        if (position != line.size() - 1) {
            return lineExist(line.get(position));
        }
        return LINE_NONE;
    }

    private static int lineExist(int position) {
        return position == LINE_EXIST ? LINE_EXIST : LINE_NONE;
    }

    public int value() {
        return position;
    }
}
