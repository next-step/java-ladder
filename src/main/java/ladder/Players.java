package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String players) {
        this.players = Arrays.stream(players.split(","))
                .map(Player::of)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getSize() {
        return this.players.size();
    }

    public int getIndex(String player) {
        for (int i = 0; i < getSize(); i++) {
            if (players.get(i).contain(player))
                return i;
        }
        throw new IllegalArgumentException();
    }
}
