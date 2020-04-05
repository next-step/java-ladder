import ladder.model.LadderGame;
import ladder.model.LadderHeight;
import ladder.model.Members;
import ladder.model.dto.LadderConsoleResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Members members = Members.newInstance(InputView.inputMembers());

        LadderHeight ladderHeight = LadderHeight.newInstance(InputView.inputLadderHeight());

        LadderGame ladderGame = LadderGame.newInstance(members, ladderHeight);

        OutputView.printResult(LadderConsoleResult.newInstance(ladderGame));
    }
}
