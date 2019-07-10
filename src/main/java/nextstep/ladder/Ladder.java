package nextstep.ladder;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();
    private int lineCount;

    private Ladder() {
    }

    public Ladder(int height, int lineCount, BooleanFunction booleanFunction) {
        this.lineCount = lineCount;
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> Line.of(lineCount, booleanFunction))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getLastMoveIndexByStartPositionIndex(int startPositionIndex) {
        int position = startPositionIndex;

        for (Line line : lines) {
            position = line.getMoveIndexByPointIndex(position);
        }
        return position;
    }

    public MatchingResult play() {

        Map<Integer, Integer> matchIngMap = IntStream.range(0, lineCount)
                .boxed()
                .collect(
                        Collectors.toMap(Function.identity()
                                , this::getLastMoveIndexByStartPositionIndex
                                , (oldValue, newValue) -> oldValue
                                , LinkedHashMap::new)
                );

        return MatchingResult.of(matchIngMap);
    }


}
