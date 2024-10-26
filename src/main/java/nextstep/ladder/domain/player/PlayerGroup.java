package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.util.StringSplitter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerGroup {

    private final List<Player> players;

    public PlayerGroup(String playersToSplit) {
        this(toList(playersToSplit));
    }

    public PlayerGroup(List<Player> players) {
        this.players = players;
    }

    private static List<Player> toList(String playersToSplit) {
        return new StringSplitter(playersToSplit)
                .indexBasedConverter((index, playerName) -> new Player(playerName, index));
    }

    public List<Player> play(Ladder ladder) {
        List<Player> toPlay = players.stream()
                .map(Player::copy)
                .collect(Collectors.toList());

        ladder.play(toPlay);
        return toPlay;
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
