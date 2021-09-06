package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class WideLadderLinesGenerator extends LadderLinesGenerator {

    @Override
    public List<LadderLine> generate(int ladderLineCount, int pointCount) {
        List<LadderLine> lines = IntStream.range(FIRST_INDEX, ladderLineCount)
                .mapToObj(index -> {
                    List<Integer> pointIndicesWithTrueRight = new ArrayList<>();
                    int pointCountExcludingLastPoint = pointCount - LAST_POINT_COUNT;

                    for (int truePointIndex = index; truePointIndex < pointCountExcludingLastPoint; truePointIndex += ladderLineCount) {
                        pointIndicesWithTrueRight.add(truePointIndex);
                    }

                    return new LadderLine(generatePoints(pointCount, pointIndicesWithTrueRight));
                })
                .collect(toList());

        return shuffled(lines);
    }
}
