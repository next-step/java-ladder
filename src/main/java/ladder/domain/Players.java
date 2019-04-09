package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> values;

    public Players(final List<Player> values) {
        this.values = values;
    }

    public Players(final String... names) {
        this(
                Arrays.stream(names)
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
    }

    public Player getPlayer(final int index) {
        return this.values.get(index);
    }

    public int getNumberOfPlayers() {
        return this.values.size();
    }
}
