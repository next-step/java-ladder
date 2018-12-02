package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.QuestionType;
import ladder.view.ResultView;

public class LadderGameConsole {

    public static void main(String args[]) {
        Participants participants = Participants
                .fromComma(InputView.inputString(QuestionType.PARTICIPANTS.getQuestion()));
        ResultItems resultItems = ResultItems.fromComma(InputView.inputString(QuestionType.RESULT_ITEMS.getQuestion()));
        Ladder ladder = Ladder.from(
                InputView.inputInteger(QuestionType.MAX_LADDER_HEIGHT.getQuestion()),
                participants);

        LadderGame ladderGame = new LadderGame(ladder);
        GameResult ladderGameResult = ladderGame.play(participants, resultItems);

        ResultView.printLadder(participants, ladder, resultItems);
        ResultView.printGameResult(ladderGameResult, InputView.inputString(QuestionType.RESULT_PARTICIPANT.getQuestion()));
    }
}
