package ladder.domain.player;

import ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String input) {
        StringUtils.validate(input);
        return new Players(Arrays.stream(StringUtils.getNamesFrom(input))
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    public Player get(int index) {
        return players.get(index);
    }

    public int getCountOfPerson() {
        return players.size();
    }
}
