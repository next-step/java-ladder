package nextstep.ladder.domain;

public class Player {

    private static final int LIMIT_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름은 공백일 수 없습니다.");
        }

        if (name.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException("플레이어의 이름이 깁니다. limit : " + LIMIT_LENGTH);
        }

        this.name = name;
    }

    public String name() {
        return name;
    }
}
