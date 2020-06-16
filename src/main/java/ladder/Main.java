package ladder;

import ladder.model.LadderGame;
import ladder.model.LadderHeight;
import ladder.model.Members;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Members members = Members.create(InputView.inputMembers());
        LadderHeight ladderHeight = LadderHeight.create(InputView.inputLadderHeight());
        LadderGame ladderGame = LadderGame.create(members, ladderHeight);
        OutputView.printResult(ladderGame);
    }
}
