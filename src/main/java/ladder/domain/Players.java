package ladder.domain;

import ladder.domain.util.SplitUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ladder.domain.Name.DEFAULT_MAX_NAME_LENGTH;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Players(String names) {
        this(toPlayers(names));
    }

    public int size() {
        return players.size();
    }

    private static List<Player> toPlayers(String names) {
        return SplitUtil.split(names)
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }


    public int namesMaxLength() {
        return names()
                .stream()
                .mapToInt(Name::length)
                .max()
                .orElse(DEFAULT_MAX_NAME_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    public List<Name> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }
}
