package ladder.domain.ladder;

import ladder.domain.line.Line;
import ladder.domain.player.Player;

import java.util.HashMap;
import java.util.List;
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

        return new LadderResult(new HashMap<>());
    }

    public static LadderResult of(Ladder ladder, String namesOfAwards) {
        return of(ladder, Awards.of(namesOfAwards));
    }

    private static void validateMatchingCount(int sizeOfPlayers, int sizeOfAwards) {
        if (sizeOfPlayers != sizeOfAwards) {
            throw new LadderResultException();
        }
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
