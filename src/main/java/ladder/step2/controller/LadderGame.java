package ladder.step2.controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.Players;
import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;
import ladder.step2.dto.*;
import ladder.step2.view.InputView;
import ladder.step2.view.ResultView;

public class LadderGame {
    public void run() {
        final Players players = InputView.inputPlayerNames();
        final PlayersDTO playersDTO = new PlayersDTO(players);
        final LadderResultsDTO ladderResultsDTO = InputView.inputLadderResults(playersDTO);
        final LadderHeightDTO ladderHeightDTO = InputView.inputLadderHeight();
        
        final Ladder ladder = Ladder.of(ladderHeightDTO.getLadderHeight(), playersDTO.getPlayerNameDTOS().size(), new RandomPartLineCreateStrategy());
        
        ResultView.resultMessagePrint();
        ResultView.playerNamesPrint(playersDTO);
        ResultView.ladderPrint(new LadderDTO(ladder));
        ResultView.ladderResultsPrint(ladderResultsDTO);
        
        
        boolean isEnd = false;
        while (!isEnd) {
            final String targetPlayer = InputView.inputTargetPlayer();
            ResultView.finalResultMessagePrint();
            isEnd = ResultView.targetPlayerResultPrint(targetPlayer, new LadderGameResultsDTO(playersDTO, ladder.move(players)), ladderResultsDTO);
        }
    }
}
