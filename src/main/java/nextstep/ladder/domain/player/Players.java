package nextstep.ladder.domain.player;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    private Players(List<String> names) {
        players = names.stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    public static Players init(List<String> names) {
        return new Players(names);
    }

}
