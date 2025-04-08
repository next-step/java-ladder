package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_SIZE = 5;
    private final String name;

    public Player(String name) {
        validateInput(name);
        this.name = name;
    }

    private void validateInput(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }

        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_SIZE + "자 입니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Player player = (Player) object;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
