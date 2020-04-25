package ladder;

import ladder.domain.RandomDirection;
import ladder.dto.LadderResponse;
import ladder.ui.LadderController;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
    private static final String TARGET_ALL = "all";
    private static final String EMPTY_DEFAULT = " ";

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new RandomDirection());

        LadderResponse ladderResponse = ladderController.run(InputView.inputLadderInfo());

        ResultView.print(ladderResponse.getLadder(), ladderResponse.getLadderGameInfo());
        String inputTarget = EMPTY_DEFAULT;
        while (!TARGET_ALL.equals(inputTarget)) {
            inputTarget = InputView.inputTarget();
            ResultView.printResult(inputTarget, ladderResponse.getLadderGameResults());
        }
    }
}
