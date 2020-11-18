package step2;

import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayers {
    private final List<Player> players;

    public LadderPlayers(List<String> names) {
        players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }
}
