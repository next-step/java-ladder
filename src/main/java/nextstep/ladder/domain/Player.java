package nextstep.ladder.domain;

public class Player {
    private static final String NAME_LENGTH_OVER = "이름은 최대 5글자까지 가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER);
        }
    }

    public String getName() {
        return name;
    }
}
