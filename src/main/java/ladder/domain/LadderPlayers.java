package ladder.domain;

import java.util.Arrays;
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

    public int totalPlayerCount() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
