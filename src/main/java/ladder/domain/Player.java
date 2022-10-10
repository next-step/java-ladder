package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_LENGTH = 5;

    private final String name;
    private final int position;

    public Player(String name, int position) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자이하 이어야 합니다");
        }

        this.name = name;
        this.position = position;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (position != player.position) return false;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }

    public Player move(Line line) {
        return new Player(name, line.nextPosition(position));
    }
}
