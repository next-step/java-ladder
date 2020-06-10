package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    private final PlayerName name;
    private final Position position;

    private Player(String name, int position) {
        this.name = PlayerName.newInstance(name);
        this.position = Position.newInstance(position);
    }

    public static Player newInstance(String name, int position) {
        return new Player(name, position);
    }

    public boolean isMatchName(PlayerName playerName) {
        return this.name.equals(playerName);
    }

    public PlayerName getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
