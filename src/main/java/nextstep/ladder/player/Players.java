package nextstep.ladder.player;

import nextstep.ladder.exception.NotFoundPlayerNameException;
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

    public int findByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .map(Player::getPosition)
                .orElseThrow(() -> new NotFoundPlayerNameException(name));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
