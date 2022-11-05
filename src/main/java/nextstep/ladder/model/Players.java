package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int number() {
        return players.size();
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining());
    }
}
