package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.Map;

public class LadderGameController {

    public void doLadderGame() {
        try {
            Participants participants = Participants.of(InputView.readParticipantNames());
            List<String> prizes = InputView.readLadderGamePrizes(participants.numberOf());
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
            name = InputView.readNameForGameResult();
            ResultView.printLadderGameResult(prizeMap, name);
        }
    }
}
