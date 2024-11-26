package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderLinesGenerator;
import java.util.Optional;

public class RandomLaddersFactory extends LaddersFactory {
    private static final Integer INIT_POSITION = 0;

    public Ladder createLadder(Optional<Ladder> beforeLadder, int maxHeight, LadderLinesGenerator ladderLinesGenerator) {
        return new Ladder(
                beforeLadder.map(Ladder::nextPosition).orElse(INIT_POSITION),
                ladderLinesGenerator.generate(beforeLadder, maxHeight)
        );
    }

}
