import ladder.LadderGame;
import ladder.LadderHeight;
import ladder.Members;
import ladder.view.InputView;
import ladder.view.OutputView;

import static ladder.utils.LadderUtil.separateLineWithComma;

public class Main {
    public static void main(String[] args) {
        Members members = Members.newInstance(separateLineWithComma(InputView.inputMembers()));

        LadderHeight ladderHeight = LadderHeight.newInstance(InputView.inputLadderHeight());

        LadderGame ladderGame = LadderGame.newInstance(members, ladderHeight);

        OutputView.printResult(ladderGame);
    }
}
