package nextstep.ladder;

import nextstep.ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String names) {
        return new Players(toMap(names));
    }

    public List<Player> getPlayers() {
        return players;
    }

    private static List<Player> toMap(String names) {
        String[] split = StringUtil.split(names);

        return Arrays.stream(split)
                .map(Player::of)
                .collect(Collectors.toList());
    }
}
