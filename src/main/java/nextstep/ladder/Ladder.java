package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Player> players;
    private final Height height;

    public Ladder(List<String> players, int height) {
        this.players = players.stream().map(Player::new).collect(Collectors.toList());
        this.height = new Height(height);
    }
}
