package ladder.domain;

import ladder.domain.util.LineGenerator;
import ladder.exception.LineException;
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
    public static final String NOT_ALLOWED_CREATE_ADJACENT_LINE_MESSAGE = "사다리 라인을 겹치게 만들 수 없습니다.";
    public static final int START_INCLUSIVE = 0;
    public static final int END_EXCLUSIVE_OFFSET = 1;
    public static final int NEXT_INDEX_OFFSET = 1;
    public static final int MIN_PLAYERS_COUNT = 1;
    private final List<Boolean> point;

    public Line(int playersCount, LineGenerator generator) {
        this(generateLine(playersCount, generator));
    }

    public Line(List<Boolean> point) {
        validatePoint(point);
        this.point = point;
    }

    private static void validatePoint(List<Boolean> line) {
        boolean isAdjacentLine = IntStream
                .range(START_INCLUSIVE, line.size() - END_EXCLUSIVE_OFFSET)
                .boxed()
                .anyMatch(index ->
                        line.get(index) &&
                        line.get(index + NEXT_INDEX_OFFSET)
                );
        if (isAdjacentLine) {
            throw new LineException(NOT_ALLOWED_CREATE_ADJACENT_LINE_MESSAGE);
        }
    }

    private static List<Boolean> generateLine(int playersCount, LineGenerator generator) {
        if (playersCount < MIN_PLAYERS_COUNT) {
            throw new PlayersCountException(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);
        }
        AtomicReference<Boolean> prev = new AtomicReference<>();
        return IntStream.range(START_INCLUSIVE, playersCount - END_EXCLUSIVE_OFFSET)
                .boxed()
                .map(toBoolean(prev, generator))
                .collect(Collectors.toList());
    }

    //TODO: https://github.com/next-step/java-ladder/pull/2264#discussion_r1831117917
    private static Function<Integer, Boolean> toBoolean(AtomicReference<Boolean> previous,
                                                        LineGenerator lineGenerator) {
        return index -> {
            boolean horizontal = lineGenerator.generate();

            if (index > START_INCLUSIVE && previous.get().equals(true)) {
                horizontal = false;
            }
            previous.set(horizontal);
            return horizontal;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(point, line1.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    public List<Boolean> getPoint() {
        return Collections.unmodifiableList(point);
    }
}
