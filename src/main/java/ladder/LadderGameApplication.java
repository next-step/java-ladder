package ladder;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> participants = inputView.getParticipants();
        int height = inputView.getLadderHeight();
        LadderGame ladderGame = new LadderGame(participants, height);
        OutputView outputView = new OutputView(ladderGame);
        outputView.printResult();
    }
}
