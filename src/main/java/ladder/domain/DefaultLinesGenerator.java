package ladder.domain;

import ladder.utils.RandomUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLinesGenerator implements LinesGenerator {
    private static final int SIZE_OF_FIRST_AND_LAST_POINT = 2;

    private final int numberOfPlayers;
    private final int height;

    public DefaultLinesGenerator(final int numberOfPlayers, final int height) {
        this.numberOfPlayers = numberOfPlayers;
        this.height = height;
    }

    @Override
    public Lines generate() {
        return new Lines(
                IntStream.rangeClosed(1, this.height)
                        .mapToObj(time -> generateLine())
                        .collect(Collectors.toList())
        );
    }

    private Line generateLine() {
        boolean current = RandomUtils.nextBoolean();
        final Line.Builder builder = new Line.Builder();
        builder.point(current);

        final int betweenSize = getBetweenSize();
        for (int number = 0; number < betweenSize; number++) {
            current = getNext(current);
            builder.point(current);
        }

        return builder.build();
    }

    private int getBetweenSize() {
        return this.numberOfPlayers - SIZE_OF_FIRST_AND_LAST_POINT;
    }

    private boolean getNext(final boolean current) {
        return !(current || RandomUtils.nextBoolean());
    }
}
