package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(Height height, int sizeOfPerson, DirectionPredicate predicate) {
        this.lines = createLines(height, sizeOfPerson, predicate);
    }

    private List<Line> createLines(Height height, int sizeOfPerson, DirectionPredicate predicate) {
        return IntStream.range(0, height.getHeight())
                .unordered()
                .mapToObj(integer -> Line.init(sizeOfPerson, predicate))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int startPoint) {
        int point = startPoint;
        for (int i = 0; i < getLines().size(); i++) {
            point = lines.get(i).move(point);
        }
        return point;
    }
}
