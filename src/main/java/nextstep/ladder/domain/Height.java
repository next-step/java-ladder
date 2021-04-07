package nextstep.ladder.domain;

public class Height {

    private static final int HEIGHT_MINIMUM_BOUND = 1;
    private static final String HEIGHT_VALIDATE_MESSAGE = "사다리의 높이는 1 이상이어야 합니다.";
    private static final String HEIGHT_NOT_PARSABLE_MESSAGE = "사다리 높이는 숫자를 입력해주세요";

    private final int height;

    public Height(final String height) {
        isParsable(height);
        this.height = Integer.parseInt(height);
        validateHeight();
    }

    private static void isParsable(String inputHeight) {
        try {
            Integer.parseInt(inputHeight);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(HEIGHT_NOT_PARSABLE_MESSAGE);
        }
    }

    private void validateHeight() {
        if (this.height < HEIGHT_MINIMUM_BOUND) {
            throw new IllegalArgumentException(HEIGHT_VALIDATE_MESSAGE);
        }
    }

    public int value() {
        return this.height;
    }
}
