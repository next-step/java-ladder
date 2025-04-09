package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String REGEX = ",";

    public final List<Player> players;
    public final int ladderHeight;

    public LadderGame(String players, int ladderHeight) {
        this.players = createPlayers(players);
        this.ladderHeight = ladderHeight;
    }

    private List<Player> createPlayers(String players) {
        return Arrays.stream(players.split(REGEX))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderGame that = (LadderGame) o;
        return ladderHeight == that.ladderHeight && Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, ladderHeight);
    }
}
