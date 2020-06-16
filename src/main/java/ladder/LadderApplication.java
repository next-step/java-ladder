package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        //참가자 생성
        String nameOfPerson = InputView.enterNameOfPerson();
        Participants participants = Participants.from(nameOfPerson);

        //사다리 생성
        int ladderHeight = InputView.enterLadderHeight();
        int countOfPerson = participants.tellCountOfPerson();
        Ladder ladder = Ladder.valueOf(ladderHeight, countOfPerson);

        //결과 출력
        ResultView.printLadder(participants, ladder);

    }
}
