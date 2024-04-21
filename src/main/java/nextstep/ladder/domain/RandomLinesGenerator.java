package nextstep.ladder.domain;

import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RandomLinesGenerator implements LinesGenerator {
    private static final Random RANDOM = new Random();
    private static final int SYSTEM_CREATE_FINAL_POINT_COUNT = 1;

    private final int numberOfPlayers;
    private final int height;

    public RandomLinesGenerator(int numberOfPlayers, int height) {
        this.numberOfPlayers = numberOfPlayers;
        this.height = height;
    }

    @Override
    public Lines generate() {
        return IntStream.range(0, height)
                .mapToObj(i -> generateLineWithRandomPoints(numberOfPlayers))
                .collect(collectingAndThen(toList(), Lines::new));
    }

    private Line generateLineWithRandomPoints(int numberOfPlayers) {
        Line.LineBuilder builder = new Line.LineBuilder();
        for (int i = 0; i < numberOfPlayers - SYSTEM_CREATE_FINAL_POINT_COUNT; i++) {
            builder.point(RANDOM.nextBoolean());
        }

        return builder.build();
    }
}
