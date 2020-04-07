package ladder;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> users = InputView.inputJoinUsers();
        int ladderMaxHeight = InputView.inputLadderMaxHeight();
        LadderGame ladderGame = new LadderGame(users, ladderMaxHeight);

        ResultView.printResult(users, ladderGame.getLadder());
    }
}
