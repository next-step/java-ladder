package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_SIZE = 5;

    private final String name;

    public Player(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format("참가자명은 최대 %d글자까지 입력할 수 있습니다.", MAX_SIZE));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
