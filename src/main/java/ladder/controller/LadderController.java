package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGameData;
import ladder.domain.LadderResult;
import ladder.domain.LadderSetting;
import ladder.domain.RandomConnectionStrategy;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String[] participantNames = InputView.inputParticipantNames();
        int participantCount = participantNames.length;

        String[] outcomes = InputView.inputOutcomes();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        LadderGameData gameData = new LadderGameData(participantNames, outcomes);
        Ladder ladder = LadderGame.createLadder(new LadderSetting(maxLadderHeight, participantCount), new RandomConnectionStrategy());
        ResultView.printLadderResult(ladder, gameData);

        LadderResult ladderResult = LadderGame.playGame(ladder, gameData);

        String participantNameForOutcome = InputView.inputParticipantNameForOutcome();
        String outcomeForParticipant = LadderGame.getOutcomeForParticipant(ladderResult, participantNameForOutcome);
        ResultView.printOutcomeForParticipant(outcomeForParticipant);
    }

}
