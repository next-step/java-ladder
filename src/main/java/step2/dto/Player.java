package step2.dto;

import java.util.Objects;

public class Player {
    private static final int MAX_LIMIT = 5;

    private final String name;

    public Player(Player player) {
        this(player.name);
    }

    public Player(String name) {
        if (name.length() > MAX_LIMIT) {
            throw new RuntimeException(String.format("사람 이름은 최대 %d글자 입니다.", MAX_LIMIT));
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player1 = (Player) o;
        return Objects.equals(name, player1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
