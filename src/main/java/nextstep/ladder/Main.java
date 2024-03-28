package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class Main {

    private final static int PARTICIPANT_NAME_MAX_LENGTH = 5;

    public static void main(String[] args) {
        try {
            List<String> names = InputView.readParticipantNames();
            int height = InputView.readLadderMaxHeight();

            Participants participants = Participants.of(names, PARTICIPANT_NAME_MAX_LENGTH);
            Ladder ladder = Ladder.of(participants.numberOf(), height);
            LadderGame ladderGame = new LadderGame(participants, ladder);

            ResultView.printGameResult(ladderGame);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }

    }

}
