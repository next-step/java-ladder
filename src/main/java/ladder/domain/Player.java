package ladder.domain;

import ladder.domain.factory.ILine;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(PlayerName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public PlayerName name() {
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

    public Player move(ILine line) {
        return new Player(name, line.nextPosition(position));
    }
}
