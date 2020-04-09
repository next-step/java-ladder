package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderPoles {

    private final List<LadderPole> ladderPoles;

    private LadderPoles(final List<LadderPole> ladderPoles) {
        validate(ladderPoles);
        this.ladderPoles = Collections.unmodifiableList(ladderPoles);
    }

    private void validate(final List<LadderPole> ladderPoles) {
        if (Objects.isNull(ladderPoles) || ladderPoles.isEmpty()) {
            throw new IllegalArgumentException("ladderPoles must be existed.");
        }
    }

    public static LadderPoles newInstance(final List<LadderPole> poles) {
        return new LadderPoles(poles);
    }

    public static LadderPoles createDefault(final PoleCount count) {
        List<LadderPole> poles = IntStream.range(0, count.toInt())
                .mapToObj(LadderPole::of)
                .collect(Collectors.toList());
        return LadderPoles.newInstance(poles);
    }

    public static LadderPoles createDefault(final int count) {
        return LadderPoles.createDefault(PoleCount.of(count));
    }

    public LadderPoles nextLadderPoles(List<LadderBridge> bridges) {
        List<LadderPole> nextLadderPoles =  ladderPoles.stream()
                .map(ladderPole -> ladderPole.nextLadderPole(bridges))
                .collect(Collectors.toList());

        return newInstance(nextLadderPoles);
    }

    public List<LadderPole> getLadderPoles() {
        return ladderPoles;
    }
}
