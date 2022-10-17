package ladder.step2.controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.Players;
import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;
import ladder.step2.dto.LadderDTO;
import ladder.step2.dto.LadderHeightDTO;
import ladder.step2.dto.LadderResultsDTO;
import ladder.step2.dto.PlayersDTO;
import ladder.step2.view.InputView;
import ladder.step2.view.ResultView;

public class LadderGame {
    public void run() {
        final Players players = InputView.inputPlayerNames();
        final LadderResultsDTO ladderResultsDTO = InputView.inputLadderResults(new PlayersDTO(players));
        final LadderHeightDTO ladderHeightDTO = InputView.inputLadderHeight();
        
        final Ladder ladder = Ladder.of(ladderHeightDTO.getLadderHeight(), players.countOfPlayers(), new RandomPartLineCreateStrategy());
    
        ResultView.resultMessagePrint();
        ResultView.playerNamesPrint(new PlayersDTO(players));
        ResultView.ladderPrint(new LadderDTO(ladder));
        ResultView.ladderResultsPrint(ladderResultsDTO);
    }
}
