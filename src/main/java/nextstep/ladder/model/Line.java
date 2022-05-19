package nextstep.ladder.model;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Line {

    private static final String WIDTH_LINE = "-----";
    private static final String EMPTY_WIDTH_LINE = "     ";
    private static final String HEIGHT_LINE = "|";
    private static final String EMPTY_HEIGHT_LINE = "";

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line create(int countOfPeople) {
        List<Boolean> points = init()
                .andThen(removable())
                .apply(countOfPeople);

        return new Line(points);
    }

    private static Function<Integer, List<Boolean>> init() {
        return countOfPeople -> IntStream
                .range(0, countOfPeople)
                .mapToObj(i -> Math.round(Math.random()) == 1)
                .collect(Collectors.toList());
    }

    private static UnaryOperator<List<Boolean>> removable() {
        return points -> {
            int lastIndex = points.size() - 1;
            IntStream.range(0, lastIndex)
                    .filter(i -> points.get(i) && points.get(i + 1))
                    .forEach(i -> points.set(i + 1, false));
            points.set(lastIndex, false);

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
        int nextIndex = index + 1;
        int lastIndex = this.points.size() - 1;
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
        int lastIndex = this.points.size() - 1;
        return IntStream
                .range(0, lastIndex)
                .mapToObj(joining())
                .reduce((prev, next) -> prev + next)
                .orElseThrow();
    }
}
