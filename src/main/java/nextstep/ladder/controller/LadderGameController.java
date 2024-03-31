package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.ParticipantPosition;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderGameController {

    public void doLadderGame() {
        try {
            Participants participants = Participants.of(InputView.readParticipantNames());
            List<String> prizes = InputView.readLadderGamePrizes();
            Ladder ladder = Ladder.of(participants.numberOf(), InputView.readLadderMaxHeight());

            LadderGame ladderGame = LadderGame.of(participants, ladder);
            ResultView.printLadderGame(ladderGame, prizes);
            while (true) {
                String resultName = InputView.readNameForGameResult();
                List<ParticipantPosition> positions = ladderGame.execute(resultName);
                ResultView.printLadderGameResult(prizes, positions);

                if (resultName.equals("all")) {
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }
    }
}
