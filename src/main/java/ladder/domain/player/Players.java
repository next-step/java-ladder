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
        return new Players(Arrays.stream(StringUtils.splitByComma(input))
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    public Player get(int index) {
        return players.get(index);
    }

    public Player get(String name) {
        return players.stream()
                .filter(player -> player.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There are no participants with the same name."));
    }

    public int getCountOfPerson() {
        return players.size();
    }
}
