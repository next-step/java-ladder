package ladder.domain.ladder;

import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Pillar> pillars;

    private Ladder(final List<Pillar> pillars) {
        validatePillars(pillars);
        this.pillars = pillars;
    }

    public static Ladder of(final Height height, final int numOfPlayers) {
        return new Ladder(createPillars(height, numOfPlayers));
    }

    private static List<Pillar> createPillars(final Height height, final int numOfPlayers) {
        return Stream.generate(() -> Pillar.of(PillarCount.of(numOfPlayers)))
                .limit(height.getValue())
                .collect(Collectors.toList());
    }

    private void validatePillars(final List<Pillar> pillars) {
        if (Objects.isNull(pillars) || pillars.size() == 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    public List<Pillar> getPillars() {
        return pillars;
    }
}
