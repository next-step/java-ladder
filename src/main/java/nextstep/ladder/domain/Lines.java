package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class Lines {
    private static final LineStrategy strategy = new RandomStrategy();
    private static final int ZERO = 0;
    private final List<Line> lines;

    public Lines(List<Line> line) {
        this.lines = line;
    }

    public static Lines of(Users users, Height height) {
        return new Lines(createBy(users, height));
    }

    private static List<Line> createBy(Users users, Height height) {
        int ladderHeight = height.getHeight();
        int width = users.width();

        return IntStream.range(ZERO, ladderHeight)
            .mapToObj(i -> new Line(width, strategy))
            .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getFirstLine() {
        return lines.get(0);
    }

    public Line getLineBy(int index) {
        return lines.get(index);
    }

    public int getLinesSize() {
        return lines.size();
    }
}
