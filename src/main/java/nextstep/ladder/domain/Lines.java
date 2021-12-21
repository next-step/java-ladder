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

    private Lines(List<Line> line) {
        this.lines = line;
    }

    public static Lines of(Users users, Height height) {
        return new Lines(createBy(users, height));
    }

    private static List<Line> createBy(Users users, Height height) {
        int ladderHeight = height.getHeight();
        int userSize = users.getUsers().size();

        return IntStream.range(ZERO, ladderHeight)
            .mapToObj(i -> new Line(userSize, strategy))
            .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
