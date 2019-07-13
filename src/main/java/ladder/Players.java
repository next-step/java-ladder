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

    public int getSize(){
        return this.players.size();
    }
}
