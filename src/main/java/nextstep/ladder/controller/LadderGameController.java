package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGameController {

    public void doLadderGame() {
        try {
            Participants participants = Participants.of(InputView.readParticipantNames());
            Ladder ladder = Ladder.of(participants.numberOf(), InputView.readLadderMaxHeight());

            LadderGame ladderGame = LadderGame.of(participants, ladder);

            ResultView.printLadderGame(ladderGame);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }
    }
}
