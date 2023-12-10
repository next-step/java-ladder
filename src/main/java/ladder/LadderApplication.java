package ladder;

import ladder.dto.LadderRequest;
import ladder.dto.LadderResponse;
import ladder.service.LadderService;
import ladder.view.InputView;
import ladder.view.LinePrinter;
import ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String participant = inputView.inputParticipant();
        String[] splitParticipants = inputView.splitParticipants(participant);
        int ladderLimitCount = inputView.inputLadderLimitCount();

        LadderService ladderService = new LadderService();
        LadderResponse response = ladderService.createLadder(new LadderRequest(splitParticipants, ladderLimitCount));

        LinePrinter printer = new LinePrinter(ladderLimitCount);
        ResultView resultView = new ResultView(printer, splitParticipants, response.getLines());
        resultView.showResult();
    }
}
