package ladder.controller;

import ladder.service.LadderService;
import ladder.view.InputView;

import java.util.List;

public class LadderController {

    private InputView inputView = new InputView();

    private LadderService ladderService = new LadderService();

    public void generateLadder() {
        String participants = inputView.participants();
        List<String> verifiedParticipants = ladderService.verifiedParticipants(participants);
    }
}
