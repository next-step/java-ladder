package nextstep.laddergame.service;

import nextstep.laddergame.domain.LadderGame;

import java.util.List;

public class LadderGameService {
    public LadderGame start(List<String> participants, Integer maxHeight) {
        return new LadderGame(participants, maxHeight);
    }

}
