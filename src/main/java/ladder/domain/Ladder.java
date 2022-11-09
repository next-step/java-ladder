package ladder.domain;

import ladder.util.RandomLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static List<Line> createLadder(int countOfMember, Height ladderHeight) {
        List<Line> ladder = new ArrayList<>();
        IntStream.range(0, ladderHeight.height())
                .forEach(count -> ladder.add(new Line(countOfMember)));
        return ladder;
    }


}
