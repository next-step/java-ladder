package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.LadderView;

import java.util.Objects;

public class LadderController {

    private final LadderView ladderView;

    public LadderController(LadderView ladderView) {
        this.ladderView = ladderView;
    }

    public Players ladderGamePlayers() {
        return ladderView.playersNameInput();
    }

    public WinningItems ladderWinningItems(int countOfPlayers) {
        return ladderView.winningItemNameInput(countOfPlayers);
    }

    public Ladder createLadder(Players players, WinningItems winningItems) {
        int ladderHeight = ladderView.ladderHeightInput();

        Ladder ladder = new Ladder(ladderHeight, players);

        ladderView.ladderOutput(ladder, winningItems);

        return ladder;
    }

    public void startGame(Ladder ladder, WinningItems winningItems) {
        LadderGame ladderGame = new LadderGame(ladder, winningItems);

        while (true) {
            String name = ladderView.gameResultPlayerInput();

            LadderGameResult ladderGameResult = ladderGame.gameStart(name);

            ladderView.ladderGameOutPut(ladderGameResult);

            if (Objects.equals(name, "all")) {
                break;
            }
        }
    }
}
