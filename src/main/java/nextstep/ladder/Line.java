package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> line;

    private Line(List<Boolean> line) {
        this.line = line;
    }

    public static Line from(int count) {
        return new Line(
            IntStream.range(0, count)
                .mapToObj(i -> Boolean.FALSE)
                .collect(Collectors.toList())
        );
    }

    public int lineSize() {
        return line.size();
    }
}
