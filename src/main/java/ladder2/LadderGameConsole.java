package ladder2;

import ladder2.model.*;
import ladder2.util.DifficultlyLadderPointGenerator;
import ladder2.view.InputView;
import ladder2.view.QuestionType;
import ladder2.view.ResultView;

public class LadderGameConsole {

    public static void main(String args[]) {
        Participants participants = Participants
                .fromComma(InputView.inputString(QuestionType.PARTICIPANTS.getQuestion()));
        ResultItems resultItems = ResultItems
                .fromComma(InputView.inputString(QuestionType.RESULT_ITEMS.getQuestion()));

        Difficultly difficultly = Difficultly.from(InputView.inputString(QuestionType.LADDER_DIFFICULTY.getQuestion()));
        DifficultlyLadderPointGenerator ladderPointGenerator = DifficultlyLadderPointGenerator
                .from(difficultly);
        Ladder ladder = Ladder.from(
                difficultly.getLineHeight(),
                participants,
                ladderPointGenerator);

        LadderGame ladderGame = new LadderGame(ladder);
        GameResult ladderGameResult = ladderGame.play(participants, resultItems);

        ResultView.printLadder(participants, ladder, resultItems);
        ResultView.printGameResult(ladderGameResult, InputView.inputString(QuestionType.RESULT_PARTICIPANT.getQuestion()));
    }
}
