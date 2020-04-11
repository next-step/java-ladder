package ladder.domain;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    private final String name;
    private final int order;

    public static Player of(String name, int order) {
        return new Player(name, order);
    }

    private Player(String name, int order) {
        validate(name, order);
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public boolean isOrder(int order) {
        return this.order == order;
    }

    private void validate(String name, int order) {
        if (order < 1) {
            throw new IllegalArgumentException("순서는 0보다 커야 합니다.");
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("이름이 %d보다 깁니다.", NAME_MAX_LENGTH));
        }
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(String.format("이름이 %d보다 짧습니다.", NAME_MIN_LENGTH));
        }
    }
}
