package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return this.players.size();
    }

    public List<Player> players() {
        return Collections.unmodifiableList(this.players);
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

    public Players findPlayer(String playerName) {
        return new Players(
                this.players
                        .stream()
                        .filter(player -> player.name().equals(playerName))
                        .collect(Collectors.toList())
        );
    }

    public List<LadderResult> results(Ladder ladder, List<String> rewards) {
        return this.players
                .stream()
                .map(player -> player.result(ladder, rewards))
                .collect(Collectors.toList());
    }
}
