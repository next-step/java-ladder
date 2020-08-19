package ladder.domain.core.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import ladder.ui.result.DisplayResult;
import ladder.ui.result.DisplayResults;
import ladder.ui.result.MovablePointsDisplayResult;

import static java.util.stream.Collectors.toList;

public class MovableLines implements Line {
    private final List<MovablePoints> lines;

    MovableLines(List<MovablePoints> lines) {
        this.lines = lines;
    }

    public static MovableLines of(int height, final int maxPointCount){
        List<MovablePoints> movablePoints = Stream.generate(() -> MovablePoints.of(maxPointCount))
                                                  .limit(height)
                                                  .collect(toList());
        return new MovableLines(Collections.unmodifiableList(movablePoints));
    }

    static List<Integer> getLineByPointIndexPathResult(List<MovablePoints> lines, int startIndex) {
        int size = lines.size();

        List<Integer> result = new ArrayList<>(size);
        result.add(lines.get(0).move(startIndex));
        for (int i = 1; size > i; ++i) {
            MovablePoints line = lines.get(i);
            result.add(line.move(result.get(i-1)));
        }

        return result;
    }

    List<MovablePointsDisplayResult> collectMovablePointsDisplayResultList() {
        return lines.stream()
                    .map(MovablePoints::collectLinkState)
                    .map(MovablePointsDisplayResult::new)
                    .collect(toList())
            ;
    }

    @Override
    public DisplayResult toDisplayResult() {
        return new DisplayResults(collectMovablePointsDisplayResultList());
    }
}
