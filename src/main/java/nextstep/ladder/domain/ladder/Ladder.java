package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = lines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder of(int width, int height) {
        return new Ladder(createLines(height, width), LadderHeight.of(height));
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines, LadderHeight.of(lines.size()));
    }

    private static List<Line> createLines(int height, int width) {
        return IntStream.range(0, height)
                .mapToObj(i -> Line.ofWidth(width))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return ladderHeight.getHeight();
    }

    public int followFrom(int startPoint) {
        int point = startPoint;
        for (int i = 0; i < ladderHeight.getHeight(); i++) {
            point = lines.get(i).followFrom(point);
        }
        return point;
    }

    public List<String> followAllLinesToEndPoint(List<String> endPoints) {
        return IntStream.range(0, lines.get(0).getWidth())
                .mapToObj(this::followFrom)
                .map(endPoints::get)
                .collect(Collectors.toList());
    }
}
