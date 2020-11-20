package step3.controller;

import step3.ladder.Ladder;
import step3.ladder.LadderGame;
import step3.ladder.LadderPlayers;
import step3.ladder.dto.LadderBuildDTO;
import step3.strategy.MakeLadderLineStrategy;
import step3.view.ConsoleViewImpl;
import step3.view.LadderGameInputView;
import step3.view.LadderGameResultView;
import step3.view.View;

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
