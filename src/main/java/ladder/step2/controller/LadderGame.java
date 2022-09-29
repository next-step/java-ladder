package ladder.step2.controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.LadderFactory;
import ladder.step2.domain.Player;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import ladder.step2.view.input.InputView;
import ladder.step2.view.output.ResultView;

import java.util.List;

public class LadderGame {
    public void play() {
        List<Player> players = InputView.inputPlayerNames();
        int ladderHeight = InputView.inputLadderHeight();
    
        Ladder ladder = createLadder(players, ladderHeight);
    
        ResultView.ladderPrint(ladder);
    }
    
    private Ladder createLadder(List<Player> players, int ladderHeight) {
        return LadderFactory.of(players, ladderHeight, new RandomLineCreateStrategy());
    }
}
