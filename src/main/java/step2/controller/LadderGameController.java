package step2.controller;

import step2.domain.ladder.Ladder;
import step2.domain.ladder.LadderGame;
import step2.domain.ladder.LadderPlayers;
import step2.domain.ladder.dto.LadderBuildDTO;
import step2.strategy.MakeLadderLineStrategy;
import step2.view.LadderGameInputView;
import step2.view.LadderGameResultView;

public class LadderGameController {
    private final LadderGameInputView ladderGameInputView;
    private final LadderGameResultView ladderGameResultView;

    public LadderGameController() {
        ladderGameInputView = new LadderGameInputView();
        ladderGameResultView = new LadderGameResultView();
    }

    public void play() {
        String playerNames = ladderGameInputView.getPlayerNames();
        Integer ladderHeight = ladderGameInputView.getLadderHeight();

        LadderPlayers players = LadderGame.join(playerNames);
        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, ladderHeight), new MakeLadderLineStrategy());

        ladderGameResultView.drawLadder(players, ladder);
    }
}
