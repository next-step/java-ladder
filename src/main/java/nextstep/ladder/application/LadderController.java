package nextstep.ladder.application;

import nextstep.ladder.application.dto.LadderRequest;
import nextstep.ladder.application.dto.LadderResponse;
import nextstep.ladder.application.service.LadderService;
import nextstep.ladder.ui.LinePrinter;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] participants = splitParticipants(inputView);
        int highCount = inputView.inputHighCount();

        LadderService ladderService = new LadderService();
        LadderResponse response = ladderService.createLadder(new LadderRequest(participants, highCount));

        LinePrinter printer = new LinePrinter(highCount);
        ResultView resultView = new ResultView(printer, participants, response.getLines());
        resultView.showResult();
    }

    private static String[] splitParticipants(InputView inputView) {
        return inputView.inputParticipant()
                .split(",");
    }
}
