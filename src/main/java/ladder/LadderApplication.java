package ladder;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        //참가자 생성
        String nameOfPerson = InputView.enterNameOfPerson();
        Participants participants = Participants.valueOf(nameOfPerson);
        int countOfPerson = participants.size();

        // 결과 생성
        String enteredResults = InputView.enterResults();
        Results results = Results.valueOf(enteredResults, countOfPerson);

        // 사다리 생성
        int ladderHeight = InputView.enterLadderHeight();
        Ladder ladder = Ladder.valueOf(ladderHeight, countOfPerson);

        //결과 출력
        ResultView.printLadder(participants, ladder, results);

    }
}
