package ladder.step2.controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.LadderFactory;
import ladder.step2.domain.Players;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import ladder.step2.dto.LadderDTO;
import ladder.step2.dto.LadderHeightDTO;
import ladder.step2.view.input.InputView;
import ladder.step2.view.output.ResultView;

public class LadderGame {
    public void play() {
        Players players = InputView.inputPlayerNames();
        LadderHeightDTO ladderHeight = InputView.inputLadderHeight();
        
        Ladder ladder = LadderFactory.of(players.size(), ladderHeight, new RandomLineCreateStrategy());
        resultPrint(players, ladder);
    }
    
    private void resultPrint(Players players, Ladder ladder) {
        ResultView.resultMessagePrint();
        ResultView.playerNamesPrint(players);
        ResultView.ladderPrint(new LadderDTO(ladder));
    }
}
