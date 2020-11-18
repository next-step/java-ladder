package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;
    private final LadderHeight ladderHeight;

    public Ladder(List<LadderLine> ladderLines, LadderHeight ladderHeight) {
        this.ladderLines = ladderLines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder of(int width, int height) {
        return new Ladder(createLines(height, width), LadderHeight.of(height));
    }

    public static Ladder of(List<LadderLine> ladderLines) {
        return new Ladder(ladderLines, LadderHeight.of(ladderLines.size()));
    }

    private static List<LadderLine> createLines(int height, int width) {
        return IntStream.range(0, height)
                .mapToObj(i -> LadderLine.ofWidth(width))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int getHeight() {
        return ladderHeight.getHeight();
    }

    public int followFrom(int startPoint) {
        int point = startPoint;
        for (LadderLine ladderLine : ladderLines) {
            point = ladderLine.followFrom(point);
        }
        return point;
    }

    public List<String> followAllLinesToEndPoint(List<String> endPoints) {
        return IntStream.range(0, ladderLines.get(0).getWidth())
                .mapToObj(this::followFrom)
                .map(endPoints::get)
                .collect(Collectors.toList());
    }
}
