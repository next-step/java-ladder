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
        String[] participants = inputView.inputParticipant();
        String[] results = inputView.inputResults();
        int highCount = inputView.inputHighCount();

        LadderService ladderService = new LadderService();
        LadderResponse createResponse = ladderService.findWinner(new LadderRequest(
                participants,
                results,
                highCount));

        LinePrinter printer = new LinePrinter(highCount);
        ResultView resultView = new ResultView(
                printer,
                createResponse.getLines(),
                createResponse.getParticipants(),
                results);
        resultView.showLadder();
        resultView.showParticipant(inputView.inputWantShow());
        resultView.showParticipant(inputView.inputWantShow());
    }
}
