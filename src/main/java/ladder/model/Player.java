package ladder.model;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("참가자 이름이 비어있습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("참가자 이름은 %d자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player that = (Player) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
