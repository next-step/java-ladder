package nextstep.ladder.domain.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.exception.NotExistsPlayerNameException;

public class Players {

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final List<Player> players) {
        return new Players(players);
    }

    public static Players of(final String names) {
        return Players.of(
            Arrays.stream(names.split(","))
                .map(Name::of)
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    public int size() {
        return players.size();
    }

    public Player getByName(final Name name) {
        return players.stream()
            .filter(player -> player.getName().equals(name))
            .findFirst()
            .orElseThrow(NotExistsPlayerNameException::new);
    }

    public int indexOf(final Player player) {
        return players.indexOf(player);
    }

    public boolean contains(final Player player) {
        return players.contains(player);
    }

    public List<Player> getValues() {
        return Collections.unmodifiableList(players);
    }
}
