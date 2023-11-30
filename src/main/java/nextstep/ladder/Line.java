package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final RandomLineGenerator randomLineGenerator = RandomLineGenerator.getInstance();
    private final List<Boolean> line;

    private Line(List<Boolean> line) {
        this.line = line;
    }

    public static Line from(int count) {
        return new Line(
            IntStream.range(0, count)
                .mapToObj(i -> randomLineGenerator.randomLine())
                .collect(Collectors.toList())
        );
    }

    public List<Boolean> line() {
        return line;
    }


    public int lineSize() {
        return line.size();
    }
}
