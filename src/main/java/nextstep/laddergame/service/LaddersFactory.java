package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderLinesGenerator;
import nextstep.laddergame.domain.Ladders;
import nextstep.laddergame.domain.Lines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class LaddersFactory {
    public Ladders createLadders(int participantsSize, int maxHeight, LadderLinesGenerator ladderLinesGenerator) {
        List<Ladder> newLadders = new ArrayList<>();
        Ladder beforeLadder = null;

        for (int i = 0; i < participantsSize - 1; i++) {
            Ladder ladder = createLadder(Optional.ofNullable(beforeLadder), maxHeight, ladderLinesGenerator);
            newLadders.add(ladder);
            beforeLadder = ladder;
        }

        newLadders.add(createLastLadder(participantsSize, maxHeight));
        return new Ladders(newLadders);
    }

    public Ladder createLastLadder(int laddersSize, int height) {
        return new Ladder(laddersSize - 1, Lines.empty(height));
    }

    public abstract Ladder createLadder(Optional<Ladder> beforeLadder, int maxHeight, LadderLinesGenerator ladderLinesGenerator);

}
