package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerGroup {
    List<Player> players;

    public PlayerGroup(List<String> names) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static PlayerGroup of(List<String> names) {
        return new PlayerGroup(names);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
