package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.dto.LadderGameRequest;
import nextstep.ladder.dto.LadderGameResponse;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGameApplication {

    private static final LadderGameController ladderGameController = new LadderGameController();

    public static void main(String[] args) {
        try {
            LadderGameRequest request = InputView.createLadderGameRequest();
            LadderGameResponse response = ladderGameController.getGame(request);
            ResultView.printLadderGameResponse(response);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }

    }

}
