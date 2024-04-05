package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGameController {

    public void doLadderGame() {
        try {

            Participants participants = Participants.of(InputView.readParticipantNames());
            List<String> prizes = InputView.readLadderGamePrizes(participants.numberOf());
            int ladderHeight = InputView.readLadderMaxHeight();

            Ladder ladder = LadderFactory.of(participants.numberOf(), ladderHeight);
            ResultView.printLadder(participants, ladder);
            ResultView.printPrizes(prizes);

            Map<Participant, String> prizeMap = ladder.move(participants, prizes);
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
            name = InputView.readNameForGameResult(prizeMap.keySet());
            ResultView.printLadderGameResult(prizeMap, name);
        }
    }
}
