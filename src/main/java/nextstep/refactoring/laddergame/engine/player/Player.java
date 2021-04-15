package nextstep.refactoring.laddergame.engine.player;

import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.laddergame.engine.Positionable;

import java.util.Objects;

public class Player implements Positionable {

    private final PlayerName name;
    private final Position position;

    public Player(PlayerName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(String name, Position position) {
        return new Player(PlayerName.of(name), position);
    }

    public static Player of(String name, int position) {
        return Player.of(name, Position.of(position));
    }


    @Override
    public Position getPosition() {
        return position;
    }

    public boolean hasName(PlayerName playerName) {
        return name.equals(playerName);
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects
            .equals(getPosition(), player.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getPosition());
    }
}
