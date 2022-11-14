package ladder.model;

public class LadderHeight {
    private static final int MIN_HEIGHT = 2;

    private final int value;

    public LadderHeight(String input) {
        int value = parse(input);

        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이의 최소값은 %d입니다. 입력높이: %d", MIN_HEIGHT, value));
        }

        this.value = value;
    }

    private static int parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("높이는 빈 값이 될 수 없습니다.");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자 형식이여야 합니다. 입력값: " + input);
        }
    }

    public int getValue() {
        return value;
    }
}
