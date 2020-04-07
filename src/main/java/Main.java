import ladder.model.*;
import ladder.model.dto.LadderGameConsoleResult;
import ladder.model.dto.LadderGameMemberResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Members members = Members.newInstance(InputView.inputMembers());

        LadderGameRewords ladderGameRewords = LadderGameRewords.newInstance(InputView.inputLadderGameRewords());

        LadderHeight ladderHeight = LadderHeight.newInstance(InputView.inputLadderHeight());

        Ladder ladder = Ladder.newInstance(members.count(), ladderHeight.toInt());
        LadderGameExecutionInfo ladderGameExecutionInfo = LadderGameExecutionInfo.newInstance(members, ladderGameRewords);

        LadderGame ladderGame = LadderGame.newInstance(ladderGameExecutionInfo, ladder);

        OutputView.printLadderResult(LadderGameConsoleResult.newInstance(ladderGame));

        LadderGameResult ladderGameResult = ladderGame.start();
        OutputView.printLadderGameResult(LadderGameMemberResult.newInstance(ladderGameResult));
    }
}
