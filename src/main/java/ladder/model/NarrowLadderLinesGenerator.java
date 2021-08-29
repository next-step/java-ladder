package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NarrowLadderLinesGenerator extends LadderLinesGenerator {

    @Override
    public List<LadderLine> generate(int ladderLineCount, int pointCount) {
        List<Integer> truePointIndices = IntStream.range(FIRST_INDEX, pointCount)
                .boxed()
                .collect(toList());

        List<LadderLine> lines = IntStream.range(FIRST_INDEX, ladderLineCount)
                .mapToObj((index) -> {
                    int truePointIndex;
                    if (index < pointCount) {
                        truePointIndex = truePointIndices.get(index);
                        return LadderLine.of(pointCount, Collections.singletonList(truePointIndex));
                    }
                    return LadderLine.of(pointCount);
                })
                .collect(toList());

        return shuffled(lines);
    }
}
