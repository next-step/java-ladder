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

    @Override
    public Position getPosition() {
        return position;
    }

    public boolean hasName(PlayerName playerName) {
        return name.equals(playerName);
    }
}
