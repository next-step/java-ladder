package ladder.domain.ladder;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineMaker {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Line failed. barCount must be at least %d: barCount=%d";
    private static final int MINIMUM_COUNT = 1;

    private final Random random = new Random();
    private static final LineMaker lineMaker = new LineMaker();

    public static Line makeLine(int barCount) {
        if (barCount < MINIMUM_COUNT) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_COUNT, barCount));
        }

        return Line.of(lineMaker.getBarList(barCount));
    }

    private List<Boolean> getBarList(int barCount) {
        return Stream.iterate(random.nextBoolean(), this::getNextBoolean)
                .limit(barCount)
                .collect(Collectors.toList());
    }

    private Boolean getNextBoolean(Boolean beforeBar) {
        if (beforeBar) {
            return false;
        }
        return random.nextBoolean();
    }
}
