package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_LENGTH = 5;

    private final String name;
    private final Position position;

    public Player(String name, Position position) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자이하 이어야 합니다");
        }

        this.name = name;
        this.position = position;
    }

    public String name() {
        return name;
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (!Objects.equals(name, player.name)) return false;
        return Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    public Player move(Line line) {
        return new Player(name, line.nextPosition(position));
    }
}
