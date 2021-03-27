package ladder.controller;

import ladder.service.LadderService;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private LadderService ladderService = new LadderService();

    public void generateLadder() {
        String participants = inputView.participants();
        List<String> verifiedParticipants = ladderService.verifiedParticipants(participants);

        int maximumLadderHeight = inputView.maximumLadderHeight();
        int verifiedMaximumLadderHeight = ladderService.verifiedMaximumLadderHeight(maximumLadderHeight);

        List<String> ladderMap = ladderService.ladderMap(verifiedParticipants, verifiedMaximumLadderHeight);
        resultView.printLadderMap(ladderMap);
    }
}
