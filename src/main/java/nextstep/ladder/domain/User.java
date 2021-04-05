package nextstep.ladder.domain;

import java.util.Objects;

public class User {

    private static final int NAME_MAX_SIZE = 5;
    private static final int NAME_MIN_SIZE = 1;
    private final String name;
    private final Position position;

    private User(final String name) {
        this(name, Position.valueOf(0));
    }

    private User(final String name, final int position) {
        this(name, Position.valueOf(position));
    }

    private User(final String name, final Position position) {
        if(name.length() > NAME_MAX_SIZE || name.length() < NAME_MIN_SIZE) {
            throw new IllegalArgumentException("이름은 한 글자 이상 최대 5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public static User valueOf(final String name) {
        return new User(name);
    }

    public static User valueOf(final String name, final int position) {
        return new User(name, position);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        final User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return String.format("%s, %s", name, position);
    }
}
