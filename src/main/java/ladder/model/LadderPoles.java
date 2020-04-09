package ladder.model;

import java.util.Arrays;
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

    public static LadderPoles newInstance(final int ...poles) {
        List<LadderPole> ladderPoles = Arrays.stream(poles)
                .mapToObj(LadderPole::of)
                .collect(Collectors.toList());

        return new LadderPoles(ladderPoles);
    }

    public LadderGameRewords convertToGameRewords(final LadderGameRewords ladderGameRewords) {
        if(ladderPoles.size() != ladderGameRewords.count()) {
            throw new IllegalArgumentException("ladderGameRewords count must be same as ladderPoles count to map ths game rewords result.");
        }

        List<LadderGameReword> mappedLadderGameRewords = ladderPoles.stream()
                .map(pole -> ladderGameRewords.get(pole.toInt()))
                .collect(Collectors.toList());

        return LadderGameRewords.newInstance(mappedLadderGameRewords);
    }
}
