package ladder;

import ladder.domain.LadderGame;
import ladder.dto.LadderResultDTO;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        final String usersExpression = InputView.plzEnterUserNames();
        final int ladderHeight = InputView.plzEnterLadderHeight();
        
        final LadderGame ladderGame = LadderGame.of(usersExpression, ladderHeight);
        final LadderResultDTO ladderResultDTO = ladderGame.getLadderViewResult();

        OutputView.printLadderViewResult(ladderResultDTO);
    }
}
