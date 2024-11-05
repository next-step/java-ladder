package ladder.domain;

import ladder.domain.util.HorizontalGenerator;
import ladder.exception.PlayersCountException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    public static final String NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE = "참여자명 수는 최소 1명 이상이어야 합니다";
    public static final int START = 0;
    public static final int END_OFFSET = 1;
    public static final int MIN_PLAYERS_COUNT = 1;
    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public Line(int playersCount, HorizontalGenerator generator) {
        this(generateLine(playersCount, generator));
    }

    private static List<Boolean> generateLine(int playersCount, HorizontalGenerator generator) {
        if (playersCount < MIN_PLAYERS_COUNT) {
            throw new PlayersCountException(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);
        }
        AtomicReference<Boolean> prev = new AtomicReference<>();
        int end = playersCount - END_OFFSET;
        return IntStream.range(START, end)
                .boxed()
                .map(toBoolean(prev, generator))
                .collect(Collectors.toList());
    }

    private static Function<Integer, Boolean> toBoolean(AtomicReference<Boolean> previous,
                                                        HorizontalGenerator horizontalGenerator) {
        return index -> {
            Boolean horizontal = horizontalGenerator.generate();
            if (index == START) {
                previous.set(horizontal);
            }
            if (index > START && previous.get().equals(true)) {
                horizontal = false;
                previous.set(horizontal);
            }
            if (index > START) {
                previous.set(horizontal);
            }
            return horizontal;
        };
    }

    public List<Boolean> line() {
        return Collections.unmodifiableList(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
