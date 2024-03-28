package ladder2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {

    private final Map<Integer, Player> players;

    public Players(List<Player> players) {
        this(
            players.stream().collect(
                Collectors.toMap(Player::index, player -> player)
            )
        );
    }

    public Players(Map<Integer, Player> players) {
        this.players = players;
    }

    public void sendPrize(int index, Prize prize) {
        get(index).receivePrize(prize);
    }

    private Player get(int index) {
        return players.get(index);
    }
}
