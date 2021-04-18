package step02.utils;

import step02.exception.OutOfNameLengthException;
import step02.exception.ZeroHeightException;

public class Validation {
    private final static String ERROR_ZERO_LINE = "사다리는 높이 0이상으로 입력해주세요.";
    private final static String ERROR_NAME_LENGTH = "이름은 %d~%d글자 이내로 입력해주세요";
    private final static int MAX_NAME_LENGTH = 5;
    private final static int MIN_NAME_LENGTH = 1;
    private final static int ZERO = 0;

    private Validation() {}

    public static void checkNameLength(String name) throws OutOfNameLengthException {
        if (name.length() <= ZERO || name.length() > MAX_NAME_LENGTH) {
            throw new OutOfNameLengthException(String.format(ERROR_NAME_LENGTH, MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public static void checkZeroLine(int height) throws ZeroHeightException {
        if (height <= ZERO) {
            throw new ZeroHeightException(ERROR_ZERO_LINE);
        }
    }
}
