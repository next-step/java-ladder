package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders {

    private static final String LADDER_DELIMITER = "\n";
    private final int numberOfPoints;
    private final int height;
    private final List<Ladder> ladders;

    public Ladders(int numberOfParticipants, int height) {
        this.numberOfPoints = numberOfParticipants * 2 - 1;
        this.height = height;
        this.ladders = generateLadders(this.numberOfPoints, this.height);
    }

    private List<Ladder> generateLadders(int numberOfPoints, int height) {
        return IntStream.range(0, height)
            .mapToObj(i -> Ladder.of(numberOfPoints))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return ladders.stream()
            .map(Ladder::toString)
            .collect(Collectors.joining(LADDER_DELIMITER));
    }
}
