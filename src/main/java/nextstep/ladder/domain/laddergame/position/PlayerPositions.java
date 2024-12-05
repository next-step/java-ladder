package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.List;

public class PlayerPositions {
    private final Players players;
    private final List<Positions> positions;

    public PlayerPositions(Players players, List<Positions> positions) {
        this.players = players;
        this.positions = positions;
    }

    public int getLastPosition(String playerName) {
        Positions playerPositions = positions.get(players.findIndexByName(playerName));
        return playerPositions.getLastPosition();
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public List<Positions> getPositions() {
        return Collections.unmodifiableList(positions);
    }

}
