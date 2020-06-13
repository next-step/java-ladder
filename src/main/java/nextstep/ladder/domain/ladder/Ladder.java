package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int FIRST_LINE = 0;
    private final List<Line> lines;

    public Ladder(Height height, int maxPosition, DirectionPredicate predicate) {
        this.lines = createLines(height, maxPosition, predicate);
    }

    private List<Line> createLines(Height height, int maxPosition, DirectionPredicate predicate) {
        return IntStream.range(0, height.getHeight())
                .unordered()
                .mapToObj(integer -> Line.newInstance(maxPosition, predicate))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public Integer getMaxPosition() {
        if(lines.size() > FIRST_LINE) {
            return lines.get(FIRST_LINE).sizeOfPositions();
        }
        return null;
    }
}
