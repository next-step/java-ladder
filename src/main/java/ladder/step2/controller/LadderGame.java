package ladder.step2.controller;

import ladder.step2.domain.*;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import ladder.step2.dto.LadderDTO;
import ladder.step2.dto.LadderHeightDTO;
import ladder.step2.dto.LadderResultsDTO;
import ladder.step2.dto.PlayersDTO;
import ladder.step2.view.input.InputView;
import ladder.step2.view.output.ResultView;

public class LadderGame {
    public void play() {
        final Players players = InputView.inputPlayerNames();
        final LadderResults ladderResults = InputView.ladderResults(new PlayersDTO(players));
        final LadderHeightDTO ladderHeight = InputView.inputLadderHeight();
        
        final Ladder ladder = LadderFactory.of(players.size(), ladderHeight, new RandomLineCreateStrategy());
        final LadderGameResults ladderGameResults = players.parseLadderGameResults(new LadderDTO(ladder), new LadderResultsDTO(ladderResults));
        
    
        resultPrint(players, ladder, ladderResults);
    }
    
    private void resultPrint(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        ResultView.resultMessagePrint();
        ResultView.playerNamesPrint(new PlayersDTO(players));
        ResultView.ladderPrint(new LadderDTO(ladder));
        ResultView.ladderResultsPrint(new LadderResultsDTO(ladderResults));
    }
}
