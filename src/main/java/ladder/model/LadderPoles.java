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

    public List<LadderPole> getLadderPoles() {
        return ladderPoles;
    }
}
