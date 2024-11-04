package ladder.controller;

import ladder.domain.*;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String[] participantNames = InputView.inputParticipantNames();
        int participantCount = participantNames.length;

        String[] outcomes = InputView.inputOutcomes();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        LadderGame ladderGame = new LadderGame();
        LadderGameData gameData = new LadderGameData(participantNames, outcomes);
        Ladder ladder = ladderGame.createLadder(new LadderSetting(participantCount, maxLadderHeight), new RandomConnectionStrategy());
        ResultView.printLadderResult(ladder, gameData);

        LadderResult ladderResult = ladderGame.playGame(ladder, gameData);

        String participantNameForOutcome = InputView.inputParticipantNameForOutcome();
        String outcomeForParticipant = ladderGame.getOutcomeForParticipant(ladderResult, participantNameForOutcome);
        ResultView.printOutcomeForParticipant(outcomeForParticipant);
    }

}
