package nextstep.ladder.application;

import nextstep.ladder.application.dto.LadderRequest;
import nextstep.ladder.application.dto.LadderResponse;
import nextstep.ladder.application.service.LadderService;
import nextstep.ladder.ui.InputView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] participants = splitParticipants(inputView);
        int highCount = inputView.inputHighCount();

        LadderService ladderService = new LadderService();
        LadderResponse response = ladderService.createLadder(new LadderRequest(participants, highCount));
    }

    private static String[] splitParticipants(InputView inputView) {
        return inputView.inputParticipant()
                .split(",");
    }
}
