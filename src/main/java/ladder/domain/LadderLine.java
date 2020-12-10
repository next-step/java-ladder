package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {

    private static final int START_INDEX = 0;

    private final List<Boolean> value;

    public LadderLine(Participants participants) {
        this.value = initLadder(participants);
    }

    private List<Boolean> initLadder(Participants participants) {

        TransverseLadder transverseLadder = new TransverseLadder(participants);
        int ladderSize = transverseLadder.size() + participants.size();

        return IntStream.range(START_INDEX, ladderSize)
                .mapToObj(index -> existsLadder(index, transverseLadder))
                .collect(Collectors.toList());
    }

    private Boolean existsLadder(int index, TransverseLadder transverseLadder) {
        if (isTransverseLadderPosition(index)) {
            return transverseLadder.existsLadder(index / 2);
        }
        return true;
    }

    private boolean isTransverseLadderPosition(int index) {
        return index % 2 == 1;
    }

    public List<Boolean> getValue() {
        return value;
    }
}
