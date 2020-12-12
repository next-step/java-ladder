package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {

    private static final int START_INDEX = 0;

    private final List<Boolean> points;

    public LadderLine(int participantsCount) {
        this.points = initLadder(participantsCount);
    }

    private List<Boolean> initLadder(int participantsCount) {

        TransverseLadder transverseLadder = new TransverseLadder(participantsCount);

        int ladderSize = transverseLadder.size() + participantsCount;

        return IntStream.range(START_INDEX, ladderSize)
                .mapToObj(transverseLadder::isTransverseLadder)
                .collect(Collectors.toList());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
