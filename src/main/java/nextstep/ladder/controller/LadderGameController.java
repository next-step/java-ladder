package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderGameController {

    public void doLadderGame() {
        try {
            Participants participants = Participants.of(InputView.readParticipantNames());
            List<String> prizes = InputView.readLadderGamePrizes(participants.numberOf());
            Ladder ladder = Ladder.of(participants.numberOf(), InputView.readLadderMaxHeight());

            LadderGame ladderGame = LadderGame.of(participants, ladder);
            ResultView.printLadderGame(ladderGame, prizes);

            List<ParticipantPosition> positions = ladderGame.execute();
            LadderGameResult ladderGameResult = new LadderGameResult(prizes, positions);
            printLadderGameResult(ladderGameResult);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }
    }

    private void printLadderGameResult(LadderGameResult ladderGameResult) {
        while (true) {
            String resultName = InputView.readNameForGameResult();
            ResultView.printLadderGameResult(ladderGameResult, resultName);

            if (resultName.equals("all")) {
                break;
            }
        }
    }
}
