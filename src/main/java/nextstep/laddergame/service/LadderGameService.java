package nextstep.laddergame.service;

import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.domain.LadderLinesGenerator;

import java.util.List;

public class LadderGameService {
    public LadderGame start(List<String> participants, Integer maxHeight,
                            LaddersFactory laddersFactory, LadderLinesGenerator ladderLinesGenerator) {
        return new LadderGame(participants, maxHeight, laddersFactory, ladderLinesGenerator);
    }

}
