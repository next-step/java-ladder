package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_COUNT_OF_PERSON = 2;

    private static final int MIN_HEIGHT_OF_LADDER = 1;

    private final List<Line> lines;

    public Ladder(int countOfPerson, int maxHeightOfLadder) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("참여자는 최소 " + MIN_COUNT_OF_PERSON + "명 이상이어야 합니다.");
        }

        if (maxHeightOfLadder < 1) {
            throw new IllegalArgumentException("사다리의 최소 높이는 최소 " + MIN_HEIGHT_OF_LADDER +"이상이어야 합니다.");
        }

        this.lines = IntStream.range(0, maxHeightOfLadder)
                .mapToObj(idx -> Line.of(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return new ArrayList<>(lines);
    }
}
