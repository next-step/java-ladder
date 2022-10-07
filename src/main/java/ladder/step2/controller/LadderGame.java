package ladder.step2.controller;

import ladder.step2.domain.*;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import ladder.step2.dto.*;
import ladder.step2.view.input.InputView;
import ladder.step2.view.output.ResultView;

public class LadderGame {
    public void play() {
        final Players players = InputView.inputPlayerNames();
        final LadderResults ladderResults = InputView.ladderResults(new PlayersDTO(players));
        final LadderHeightDTO ladderHeight = InputView.inputLadderHeight();
        
        final Ladder ladder = LadderFactory.of(players.size(), ladderHeight, new RandomLineCreateStrategy());
        final LadderGameResults ladderGameResults = players.parseLadderGameResults(new LadderDTO(ladder), new LadderResultsDTO(ladderResults));
        
        ladderGameInformationPrint(players, ladder, ladderResults);
        ladderGameResultsPrint(ladderGameResults);
    }
    
    private void ladderGameResultsPrint(final LadderGameResults ladderGameResults) {
        boolean isEnd = true;
        while (isEnd) {
            final String targetPlayer = InputView.inputTargetPlayer();
            isEnd = ResultView.ladderGameResultsPrint(targetPlayer, new LadderGameResultsDTO(ladderGameResults));
        }
    }
    
    private void ladderGameInformationPrint(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        ResultView.resultMessagePrint();
        ResultView.playerNamesPrint(new PlayersDTO(players));
        ResultView.ladderPrint(new LadderDTO(ladder));
        ResultView.ladderResultsPrint(new LadderResultsDTO(ladderResults));
    }
}
