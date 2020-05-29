package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerNames;

public class OutputView {
    private PlayerNames playerNames;
    private Ladder ladder;

    public OutputView(PlayerNames playerNames, Ladder ladder) {
        this.playerNames = playerNames;
        this.ladder = ladder;
    }
}
