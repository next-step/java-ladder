package ladder.domain;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    private final String name;

    public static Player of(String input) {
        return new Player(input);
    }

    private Player(String input) {
        validate(input);
        this.name = input;
    }

    public String getName() {
        return name;
    }

    private void validate(String input) {
        if (input.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("이름이 %d보다 깁니다.", NAME_MAX_LENGTH));
        }
        if (input.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("이름이 %d보다 짧습니다.", NAME_MIN_LENGTH));
        }
    }
}
