package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayers {

    private List<Player> players;

    private LadderPlayers(List<Player> players) {
        this.players = players;
    }

    public static LadderPlayers createPlayers(String names) {
        return new LadderPlayers(Arrays.stream(names.trim().split(","))
            .map(PlayerName::new)
            .map(Player::new)
            .collect(Collectors.toList())
        );
    }

    public int getPlayer(Player player) {
        return players.indexOf(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int size() {
        return players.size();
    }


}
