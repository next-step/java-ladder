package ladder.model.player;

import ladder.model.row.Rows;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.Messages.WARNING_NOT_EXISTING_PLAYER;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Integer> findFinalLocationByName(Rows rows, String name) {
        return players.stream()
                .filter(it -> name.equals(it.getName()))
                .map(it -> it.findFinalLocation(rows))
                .collect(Collectors.toList());
    }
}
