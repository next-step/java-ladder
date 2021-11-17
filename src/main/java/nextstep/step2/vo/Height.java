package nextstep.step2.vo;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final String NULL_OR_LESS_HEIGHT_MESSAGE = "높이 값은 1 이상 이어야 합니다.";

    private final int value;

    private Height(int value) {
        this.value = value;
    }

    public static Height createWithString(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_LESS_HEIGHT_MESSAGE);
        }
        return create(Integer.parseInt(input));
    }

    public static Height create(int value) {
        if(value < MIN_HEIGHT) {
            throw new IllegalArgumentException(NULL_OR_LESS_HEIGHT_MESSAGE);
        }

        return new Height(value);
    }
}
