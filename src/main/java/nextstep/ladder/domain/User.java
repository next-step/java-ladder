package nextstep.ladder.domain;

public class User {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자까지 부여할 수 있습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
