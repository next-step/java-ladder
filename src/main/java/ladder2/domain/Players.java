package ladder2.domain;

import java.util.ArrayList;
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

    public Player get(int index) {
        return players.get(index);
    }

    public int count() {
        return players.size();
    }

    public Player getByName(String name) {
        return players.values().stream()
            .filter(player -> player.name().equals(name))
            .findFirst()
            .orElseThrow();
    }

    public List<String> names() {
        return players.values().stream()
            .map(Player::name)
            .collect(Collectors.toList());
    }

    public List<Player> value() {
        return new ArrayList<>(players.values());
    }
}
