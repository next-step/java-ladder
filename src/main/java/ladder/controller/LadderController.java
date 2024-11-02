package ladder.controller;

import ladder.domain.Bridge;
import ladder.domain.LadderResult;
import ladder.domain.LadderSetting;
import ladder.domain.RandomConnectionStrategy;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        String[] participantNames = InputView.inputParticipantNames();
        int participantCount = participantNames.length;

        String[] outcomes = InputView.inputOutcomes();

        int maxLadderHeight = InputView.inputMaxLadderHeight();

        LadderGame ladderGame = new LadderGame();
        List<Bridge> ladder = ladderGame.createLadder(new LadderSetting(participantCount, maxLadderHeight), new RandomConnectionStrategy());
        ResultView.printLadderResult(ladder, new LadderResult(participantNames, outcomes));

        ladderGame.playGame(participantNames, outcomes);

        String participantNameForOutcome = InputView.inputParticipantNameForOutcome();
        String outcomeForParticipant = ladderGame.getOutcomeForParticipant(participantNameForOutcome);
        ResultView.printOutcomeForParticipant(outcomeForParticipant);
    }

}
