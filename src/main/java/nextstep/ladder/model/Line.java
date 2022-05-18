package nextstep.ladder.model;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final String WIDTH_LINE = "-----";
    private static final String HEIGHT_LINE = "|";
    private static final String SEPARATOR = System.lineSeparator();

    private final List<Boolean> points;

    private Line(int maxHeight) {
        this.points = IntStream
                .range(0, maxHeight)
                .mapToObj(i -> false)
                .collect(Collectors.toList());
    }

    public static Line create(int maxHeight) {
        return new Line(maxHeight);
    }

    private Function<Boolean, String> addWidth() {
        return point -> {
            String line = HEIGHT_LINE;
            if (point) {
                line += WIDTH_LINE;
            }

            return line;
        };
    }

    private BinaryOperator<String> joining() {
        return (prev, next) -> String.join(SEPARATOR, prev, next);
    }

    public String draw() {
        return this.points
                .stream()
                .map(this.addWidth())
                .reduce(this.joining())
                .orElseThrow();
    }
}
