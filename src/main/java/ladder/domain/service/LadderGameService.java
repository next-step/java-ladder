package ladder.domain.service;

import ladder.domain.model.Ladder;

import java.util.Objects;

public class LadderGameService {
    // singleton 적용
    private static LadderGameService ladderGameService = null;

    private LadderGameService() {

    }

    public static LadderGameService createLadderGameService() {
        if (Objects.isNull(ladderGameService)) {
            return new LadderGameService();
        }
        return ladderGameService;
    }

    public void startGame(Ladder ladder) {
        ladder.playGame();
    }
}
