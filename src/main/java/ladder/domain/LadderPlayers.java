package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayers {

    private List<Player> players;

    private LadderPlayers(List<Player> players) {
        this.players = players;
    }

    public static LadderPlayers ofComma(String playersName) {
        List<Player> players = Arrays.stream(playersName.split(","))
                .map(Player::new)
                .collect(Collectors.toList());

        return new LadderPlayers(players);
    }

    int totalPlayerCount() {
        return this.players.size();
    }

    Player findNthPlayer(int n) {
        return players.get(n);
    }
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }
}
