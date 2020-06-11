package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Height height;
    private final List<Line> lines;
    private DirectionPredicate predicate;

    public Ladder(Height height, int maxPosition, DirectionPredicate predicate) {
        this.height = height;
        this.predicate = (predicate != null) ? predicate : new DirectionRandomPredicate();
        this.lines = createLines(maxPosition);
    }

    private List<Line> createLines(int maxPosition) {
        return IntStream.range(0, height.getHeight())
                .unordered()
                .mapToObj(integer -> Line.newInstance(maxPosition, predicate))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height.getHeight();
    }
}
