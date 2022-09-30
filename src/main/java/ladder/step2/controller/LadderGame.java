package ladder.step2.controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.LadderFactory;
import ladder.step2.domain.Players;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import ladder.step2.view.input.InputView;
import ladder.step2.view.output.ResultView;

public class LadderGame {
    public void play() {
        Players players = InputView.inputPlayerNames();
        int ladderHeight = InputView.inputLadderHeight();
        resultPrint(players, createLadder(players, ladderHeight));
    }
    
    private void resultPrint(Players players, Ladder ladder) {
        ResultView.resultMessagePrint();
        ResultView.playerNamesPrint(players);
        ResultView.ladderPrint(ladder);
    }
    
    private Ladder createLadder(Players players, int ladderHeight) {
        return LadderFactory.of(players, ladderHeight, new RandomLineCreateStrategy());
    }
}
