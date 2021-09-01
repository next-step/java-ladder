package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NarrowLadderLinesGenerator extends LadderLinesGenerator {

    @Override
    public List<LadderLine> generate(int ladderLineCount, int pointCount) {
        int pointCountExcludingLastPoint = pointCount - LAST_POINT_COUNT;
        List<Integer> pointIndicesWithTrueRight = IntStream.range(FIRST_INDEX, pointCountExcludingLastPoint)
                .boxed()
                .collect(toList());

        List<LadderLine> lines = IntStream.range(FIRST_INDEX, ladderLineCount)
                .mapToObj((lineIndex) -> {
                    int pointIndexWithTrueRight;

                    if (lineIndex < pointCountExcludingLastPoint) {
                        pointIndexWithTrueRight = pointIndicesWithTrueRight.get(lineIndex);
                        List<Integer> pointIndexTrueRight = Collections.singletonList(pointIndexWithTrueRight);
                        return new LadderLine(generatePoints(pointCount, pointIndexTrueRight));
                    }

                    return new LadderLine(generateRandomPoints(pointCount));
                })
                .collect(toList());

        return shuffled(lines);
    }
}
