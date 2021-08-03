package nextstep.ladder.player;

import nextstep.ladder.util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String names) {
        return new Players(toList(names));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int count() {
        return players.size();
    }

    private static List<Player> toList(String names) {
        String[] split = StringUtil.split(names);

        return Arrays.stream(split)
                .map(Player::of)
                .collect(Collectors.toList());
    }
}
