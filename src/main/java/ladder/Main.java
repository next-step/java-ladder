package ladder;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderGameInfo;
import ladder.model.LadderGameMemberResult;
import ladder.model.LadderGameResult;
import ladder.model.LadderGameRewords;
import ladder.model.LadderHeight;
import ladder.model.LadderPoleInfo;
import ladder.model.Members;
import ladder.model.dto.LadderGameResultDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
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
