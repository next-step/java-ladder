package ladder.domain.ladder;

import ladder.domain.line.Position;
import ladder.domain.player.Player;

import java.util.Optional;

public class LadderMatch {

    private final Player player;
    private final Position position;

    private LadderMatch(Player player, Position position) {
        this.player = Optional.ofNullable(player).orElseThrow(IllegalArgumentException::new);
        this.position = Optional.ofNullable(position).orElseThrow(IllegalArgumentException::new);
    }

    public static LadderMatch create(Player player, Position position) {
        return new LadderMatch(player, position);
    }

    public Player getPlayer() {
        return player;
    }

    public Position getPosition() {
        return position;
    }
}
