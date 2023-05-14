package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersGenerator {
    private static final String DEFAULT_SEPARATOR = ",";
    private PlayersGenerator() {
    }

    public static Players create(String playerNames) {
        List<Player> playerList = Arrays.stream(playerNames.split(DEFAULT_SEPARATOR))
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(playerList);
    }
}
