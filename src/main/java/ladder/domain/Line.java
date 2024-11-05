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
    public static final int MIN_PLAYERS_COUNT = 1;
    public static final String HORIZONTAL = "-";
    public static final String SPACE = " ";
    public static final String PLAYER_DELIMITER = "|";
    public static final String PREFIX = "";
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
        return IntStream.range(START, playersCount)
                .boxed()
                .map(toBoolean(prev, generator))
                .collect(Collectors.toList());
    }

    private static Function<Integer, Boolean> toBoolean(AtomicReference<Boolean> previous,
                                                        HorizontalGenerator horizontalGenerator) {
        return index -> {
            Boolean horizontal = horizontalGenerator.generate();
            if (index == START) {
                horizontal = false;
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

    public String toLineString(List<Name> names) {
        return IntStream.range(0, names.size())
                .boxed()
                .map(index -> toHorizontalString(index, names.get(index)))
                .collect(Collectors.joining(PLAYER_DELIMITER, PREFIX, PLAYER_DELIMITER));
    }

    private String toHorizontalString(Integer integer, Name name) {
        int length = name.length();
        if (line.get(integer)) {
            return HORIZONTAL.repeat(length);
        }
        return SPACE.repeat(length);
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
