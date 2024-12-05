package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderLinesGenerator;
import nextstep.laddergame.domain.Position;

import java.util.Optional;

public class RandomLaddersFactory extends LaddersFactory {

    public Ladder createLadder(Optional<Ladder> beforeLadder, int maxHeight, LadderLinesGenerator ladderLinesGenerator) {
        return new Ladder(
                beforeLadder.map(Ladder::nextPosition).orElse(new Position()),
                ladderLinesGenerator.generate(beforeLadder, maxHeight)
        );
    }

}
