package ladder;

import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.view.InputView;
import ladder.view.QuestionType;
import ladder.view.ResultView;

public class LadderGameConsole {

    public static void main(String args[]) {
        Participants participants = Participants
                .fromComma(InputView.inputString(QuestionType.PARTICIPANTS.getQuestion()));
        Ladder ladder = Ladder.from(
                InputView.inputInteger(QuestionType.MAX_LADDER_HEIGHT.getQuestion()),
                participants);

        ResultView.printResult(participants, ladder);
    }
}
