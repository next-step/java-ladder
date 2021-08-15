package step3;

import java.util.Objects;

public class User {
    public static final int USER_NAME_MAX_LENGTH = 5;

    private final String name;
    private final Position position;

    public User(String name, Position position) {
        validate(name);

        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (name.length() > USER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람의 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public String toOutputString() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isMe(String name) {
        return Objects.equals(this.name, name);
    }
}
