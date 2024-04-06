package laddergame.utilForTest;

import laddergame.domain.Player;
import laddergame.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersUtilForTest {
    public static Players newPlayers(String... players) {
        return new Players(Arrays.stream(players)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public static Players newPlayers(Player... players) {
        return new Players(List.of(players));
    }
}
