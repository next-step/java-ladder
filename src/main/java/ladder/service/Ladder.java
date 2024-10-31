package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Bridge> ladders = new ArrayList<>();

    public Ladder(int maxLadderHeight, int participantCount) {
        IntStream.range(0, maxLadderHeight)
                .forEach(ladder -> ladders.add(new Bridge(participantCount)));
    }

    public List<Bridge> getLadders() {
        return ladders;
    }

}
