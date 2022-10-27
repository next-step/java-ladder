package ladder;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<UserName> userNames = InputView.inputUserName();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(userNames.size(), ladderHeight);

        ResultView.printResult(userNames, ladder);
    }
}
