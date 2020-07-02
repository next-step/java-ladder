package ladder;

import ladder.model.*;
import ladder.model.dto.LadderGameInfo;
import ladder.model.dto.LadderGameResultDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class ladderMain {
    public static void main(String[] args) {
        Members members = Members.create(InputView.inputMembers());

        LadderGameRewords ladderGameRewords = LadderGameRewords.create(InputView.inputLadderGameRewords());

        LadderHeight ladderHeight = LadderHeight.create(InputView.inputLadderHeight());

        Ladder ladder = Ladder.create(members.count(), ladderHeight.getHeight());

        LadderGameInfo ladderGameInfo = LadderGameInfo.create(members, ladderGameRewords);

        LadderGame ladderGame = LadderGame.create(ladderGameInfo, ladder);

        OutputView.printResult(LadderGameResultDto.create(ladderGame));

        LadderGameResult ladderGameResult = ladderGame.start();
        OutputView.printLadderGameResult(LadderGameMemberResult.create(ladderGameResult));
    }
}
