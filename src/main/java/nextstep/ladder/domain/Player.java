package nextstep.ladder.domain;

public class Player {

    private static final int NAME_LENGTH_BOUND = 5;

    private final String name;

    public Player(final String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.trim().isEmpty() || name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 1글자 이상, 5글자 이하입니다");
        }
    }

    public String getName() {
        return this.name;
    }
}
