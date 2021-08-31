package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderResults {
    private final List<Player> players;
    private final List<String> results;

    public LadderResults(final List<String> players, final List<String> results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("결과 수와 참여자 수는 같아야 합니다.");
        }
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        this.results = results;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResults that = (LadderResults) o;
        return Objects.equals(players, that.players) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, results);
    }
}
