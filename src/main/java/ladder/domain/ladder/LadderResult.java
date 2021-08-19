package ladder.domain.ladder;

import ladder.domain.player.Player;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<String, String> results;

    private LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public static LadderResult of(Ladder ladder, Awards awards) {
        validateMatchingCount(ladder.getPlayers().size(), awards.size());

        return new LadderResult(ladder.getPlayers().stream()
                .collect(Collectors.toMap(Player::toString,
                        player -> awards.name(ladder.indexOfResult(player)))));
    }

    public static LadderResult of(Ladder ladder, String namesOfAwards) {
        return of(ladder, Awards.of(namesOfAwards));
    }

    private static void validateMatchingCount(int sizeOfPlayers, int sizeOfAwards) {
        if (sizeOfPlayers != sizeOfAwards) {
            throw new LadderResultException();
        }
    }

    public String resultOfPlayer(String playerName) {
        return results.get(playerName);
    }

    public Map<String, String> getResults() {
        return Collections.unmodifiableMap(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

}
