package ladder.domain.game;

import ladder.strategy.ConnectionStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created By mand2 on 2020-12-07.
 */
public class Ladder {

    public static final int MINIMUM_HEIGHT = 1;
    public static final String MESSAGE_LADDER_HEIGHT = "사다리의 높이는 최소 1이상이어야 합니다.";
    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public static Ladder of(int participantNum, ConnectionStrategy connectionStrategy, int height) {
        validate(height);
        return of(init(participantNum, connectionStrategy, height));
    }

    private static List<Line> init(int participantNum, ConnectionStrategy connectionStrategy, int height) {
        return Stream.generate(() -> Line.of(participantNum, connectionStrategy))
                .limit(height)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private static void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(MESSAGE_LADDER_HEIGHT);
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
