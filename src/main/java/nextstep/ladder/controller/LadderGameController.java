package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.Map;

public class LadderGameController {

    public void doLadderGame() {
        try {
            Participants participants = Participants.of(InputView.readParticipantNames());
            int numberOfParticipant = participants.numberOf();
            Prizes prizes = new Prizes(numberOfParticipant, InputView.readLadderGamePrizes(numberOfParticipant));
            Ladder ladder = Ladder.of(participants.numberOf(), InputView.readLadderMaxHeight());

            Map<Participant, String> prizeMap = ladder.move(participants, prizes);
            ResultView.printLadder(ladder, prizeMap);

            printPrizesRepeatedly(prizeMap);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }
    }

    private void printPrizesRepeatedly(Map<Participant, String> prizeMap) {
        String name = "";
        while (!Participants.meanAllParticipants(name)) {
            String resultName = InputView.readNameForGameResult();
            ResultView.printLadderGameResult(prizeMap, resultName);
        }
    }
}
