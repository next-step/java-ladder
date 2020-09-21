package nextstep.ladder;

import nextstep.ladder.dto.LadderResponse;
import nextstep.ladder.ui.LadderController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    private static final String TARGET_ALL = "all";
    private static final String EMPTY_DEFAULT = " ";

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();

        LadderResponse ladderResponse = ladderController.run(InputView.inputLadderInfo());

        ResultView.print(ladderResponse.getLadder(), ladderResponse.getLadderGameInfo());
        String inputTarget = EMPTY_DEFAULT;
        while (!TARGET_ALL.equals(inputTarget)) {
            inputTarget = InputView.inputTarget();
            ResultView.printResult(inputTarget, ladderResponse.getLadderGameResult());
        }
    }
}
