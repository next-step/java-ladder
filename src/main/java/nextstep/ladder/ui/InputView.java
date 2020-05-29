package nextstep.ladder.ui;

import nextstep.ladder.domain.PlayerNames;

public class InputView {
    private PlayerNames playerNames;
    private int maxLadderHeight;

    public InputView(String playerList, int maxLadderHeight) {
        this.playerNames = PlayerNames.create(playerList);
        this.maxLadderHeight = maxLadderHeight;
    }
}
