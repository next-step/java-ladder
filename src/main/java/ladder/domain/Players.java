package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private List<Player> values;

    private Players(final List<Player> values) {
        validate(values);
        this.values = values;
    }

    Players(final String... names) {
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

    private void validate(final List<Player> values) {
        if (values == null || values.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("최소 2명부터 함께 할 수 있습니다.");
        }
    }
}
