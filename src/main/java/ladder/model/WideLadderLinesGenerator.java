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
                    List<Integer> truePointIndices = new ArrayList<>();
                    for (int truePointIndex = index; truePointIndex < pointCount; truePointIndex += ladderLineCount) {
                        truePointIndices.add(truePointIndex);
                    }
                    return LadderLine.of(pointCount, truePointIndices);
                })
                .collect(toList());

        return shuffled(lines);
    }
}
