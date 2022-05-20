package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Line {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final boolean FALSE = false;
    private static final String MINIMUM_LINE_MESSAGE = "사다리 높이는 최소 2개 이상이어야 합니다.";
    private static final String WIDTH_LINE = "-----";
    private static final String EMPTY_WIDTH_LINE = "     ";
    private static final String HEIGHT_LINE = "|";
    private static final String EMPTY_HEIGHT_LINE = "";

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    private static void check(int countOfPeople) {
        Optional.of(countOfPeople)
                .filter(count -> 2 < count)
                .orElseThrow(() -> new MinimumException(MINIMUM_LINE_MESSAGE));
    }

    public static Line create(int countOfPeople) {
        check(countOfPeople);
        List<Boolean> points = init()
                .andThen(removable())
                .apply(countOfPeople);
        return new Line(points);
    }

    public static List<Line> create(int countOfPeople, int maxHeight) {
        return IntStream
                .range(ZERO, maxHeight)
                .mapToObj(i -> Line.create(countOfPeople))
                .collect(Collectors.toList());
    }

    private static Function<Integer, List<Boolean>> init() {
        return countOfPeople -> IntStream
                .range(ZERO, countOfPeople)
                .mapToObj(i -> Math.round(Math.random()) == ONE)
                .collect(Collectors.toList());
    }

    private static UnaryOperator<List<Boolean>> removable() {
        return points -> {
            int lastIndex = points.size() - ONE;
            IntStream.range(ZERO, lastIndex)
                    .filter(i -> points.get(i) && points.get(i + ONE))
                    .forEach(i -> points.set(i + ONE, FALSE));
            points.set(lastIndex, FALSE);
            return points;
        };
    }

    private String addWidth(boolean prev) {
        if (prev) {
            return WIDTH_LINE;
        }
        return EMPTY_WIDTH_LINE;
    }

    private String addHeight(int index) {
        int nextIndex = index + ONE;
        int lastIndex = this.points.size() - ONE;
        if (nextIndex == lastIndex) {
            return HEIGHT_LINE;
        }
        return EMPTY_HEIGHT_LINE;
    }

    private IntFunction<String> joining() {
        return index -> {
            boolean prev = this.points.get(index);
            return String.join(addWidth(prev), HEIGHT_LINE, addHeight(index));
        };
    }

    public String draw() {
        int lastIndex = this.points.size() - ONE;
        return IntStream
                .range(ZERO, lastIndex)
                .mapToObj(joining())
                .reduce((prev, next) -> prev + next)
                .orElseThrow();
    }
}
