package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.LadderView;

import java.util.Objects;

public class LadderController {

    private static final String ALL_PLAYER = "all";

    private final LadderView ladderView;

    public LadderController(LadderView ladderView) {
        this.ladderView = ladderView;
    }

    public Players ladderGamePlayers() {
        return ladderView.playersNameInput();
    }

    public WinningItems ladderWinningItems(int numberOfPlayers) {
        return ladderView.winningItemNameInput(numberOfPlayers);
    }

    public Ladder createLadder(Players players, WinningItems winningItems) {
        int ladderHeight = ladderView.ladderHeightInput();

        Ladder ladder = new Ladder(ladderHeight, new DefaultLineCreator(ladderHeight));

        ladderView.ladderOutput(players, ladder, winningItems);

        return ladder;
    }

    public void startGame(Players players, Ladder ladder, WinningItems winningItems) {

        LadderGame ladderGame = new LadderGame(ladder);

        String name;

        do {
            name = ladderView.gameResultPlayerInput();

            MoveResult moveResult = gameStart(name, players, ladderGame);

            ladderView.ladderGameOutPut(moveResult.map(players, winningItems));

        } while (!Objects.equals(name, ALL_PLAYER));
    }

    private MoveResult gameStart(String name, Players players, LadderGame ladderGame) {
        if (Objects.equals(name, ALL_PLAYER)) {
            return ladderGame.gameStart();
        }
        return ladderGame.gameStart(players.indexOf(name));
    }
}
