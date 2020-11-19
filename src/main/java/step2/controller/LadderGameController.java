package step2.controller;

import step2.domain.ladder.Ladder;
import step2.domain.ladder.LadderGame;
import step2.domain.ladder.LadderPlayers;
import step2.domain.ladder.dto.LadderBuildDTO;
import step2.strategy.MakeLadderLineStrategy;
import step2.view.ConsoleViewImpl;
import step2.view.LadderGameInputView;
import step2.view.LadderGameResultView;
import step2.view.View;

public class LadderGameController {
    private final View view;

    public LadderGameController(LadderGameInputView ladderGameInputView,
                                LadderGameResultView ladderGameResultView) {
        view = new ConsoleViewImpl(ladderGameInputView, ladderGameResultView);
    }

    public void play() {
        String playerNames = view.getPlayerNames();
        Integer ladderHeight = view.getLadderHeight();

        LadderPlayers players = LadderGame.join(playerNames);
        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, ladderHeight), new MakeLadderLineStrategy());

        view.drawLadder(players, ladder);
    }
}
