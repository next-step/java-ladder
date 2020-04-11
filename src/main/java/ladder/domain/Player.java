package ladder.domain;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    private final String name;

    public static Player of(String name) {
        return new Player(name);
    }

    private Player(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("이름이 %d보다 깁니다.", NAME_MAX_LENGTH));
        }
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("이름이 %d보다 짧습니다.", NAME_MIN_LENGTH));
        }
    }
}
