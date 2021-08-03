package nextstep.ladder.player;

import nextstep.ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String names) {
        return new Players(toList(names));
    }

    private static List<Player> toList(String names) {
        String[] split = StringUtil.split(names);

        return IntStream.range(0, split.length)
                .mapToObj(i -> Player.of(split[i], i))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int count() {
        return players.size();
    }
}
