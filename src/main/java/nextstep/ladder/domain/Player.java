package nextstep.ladder.domain;

public class Player {
    private static final String NAME_VALIDATE_MESSAGE = "이름은 1글자 이상, 5글자 이하입니다";
    private static final int NAME_LENGTH_BOUND = 5;
    private static final String NAME_OUTPUT_FORMAT = "%3s";

    private final String name;

    public Player(final String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.trim().isEmpty() || name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException(NAME_VALIDATE_MESSAGE);
        }
    }

    public String getName() {
        return String.format(NAME_OUTPUT_FORMAT, this.name);
    }
}
