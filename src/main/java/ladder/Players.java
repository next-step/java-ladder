package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String[] players){
        this.players = Arrays.stream(players)
                            .map(Player::new)
                            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return players.toString();
    }
}
