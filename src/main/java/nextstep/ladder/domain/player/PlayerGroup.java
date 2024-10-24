package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.util.StringUtil.toStringArray;

public class PlayerGroup {

    private final List<Player> players;

    public PlayerGroup(String playerStrings) {
        this(toList(playerStrings));
    }

    public PlayerGroup(List<Player> players) {
        this.players = players;
    }

    private static List<Player> toList(String strings) {
        String[] playerNames = toStringArray(strings);

        return IntStream.range(0, playerNames.length)
                .mapToObj(i -> new Player(playerNames[i].trim(), i))
                .collect(Collectors.toList());
    }

    public List<Player> play(Ladder ladder) {
        List<Player> toPlay = players.stream()
                .map(Player::copy)
                .collect(Collectors.toList());

        ladder.play(toPlay);
        return toPlay;
    }

    public List<String> playerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int count() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerGroup that = (PlayerGroup) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(players);
    }
}
