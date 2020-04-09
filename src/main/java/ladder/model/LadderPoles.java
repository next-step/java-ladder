package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public LadderGameRewords convertToGameRewords(LadderGameRewords originLadderGameRewords) {
        List<LadderGameReword> ladderGameRewords = ladderPoles.stream()
                .map(pole -> originLadderGameRewords.get(pole.toInt()))
                .collect(Collectors.toList());

        return LadderGameRewords.newInstance(ladderGameRewords);
    }
}
