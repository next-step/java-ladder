package ladder.domain.player;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH_BOUND = 5;
    private final String name;

    public Name(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
        this.name = name.trim();
    }

    public String getName() {
        return this.name;
    }

    private void validateNullOrEmpty(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 Null 이나 공백일 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.trim().length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다. - " + name.trim());
        }
    }
}
