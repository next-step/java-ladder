package ladder.domain.service;

import ladder.domain.model.LadderHeight;
import ladder.domain.model.Lines;
import ladder.domain.model.PlayerNames;

import java.util.Objects;

public class LadderGameService {
    // singleton 적용
    private static LadderGameService ladderGameService = null;

    protected LadderGameService() {

    }

    public static LadderGameService createLadderGameService() {
        if (Objects.isNull(ladderGameService)) {
            return new LadderGameService();
        }
        return ladderGameService;
    }

    public Lines startGame(PlayerNames playerNames, LadderHeight ladderHeight) {
        return new Lines(playerNames.getCount(), ladderHeight.getHeight());
    }

}
