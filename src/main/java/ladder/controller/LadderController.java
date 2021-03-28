package ladder.controller;

import ladder.domain.Height;
import ladder.domain.ParticipantList;
import ladder.domain.ladderMap.LadderMap;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void generateLadder() {
        String participants = inputView.getParticipants();
        ParticipantList verifiedParticipants = new ParticipantList(participants);

        int maximumLadderHeight = inputView.getMaximumLadderHeight();
        Height verifiedHeight = new Height(maximumLadderHeight);

        LadderMap ladderMap = new LadderMap(verifiedParticipants, verifiedHeight);
        resultView.printLadderMap(ladderMap);
    }

}
