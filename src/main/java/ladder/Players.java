package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String COMMA = ",";
    private final List<Player> players;

    public Players(String names) {
        this.players = Arrays.stream(names.split(COMMA))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getCountOfPerson() {
        return players.size();
    }

    @Override
    public String toString() {
        return Player.BLANK + String.join(Player.BLANK,
                players.stream()
                        .map(Player::toString)
                        .collect(Collectors.toList()));
    }
}
