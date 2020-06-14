package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;

public class LadderApplication {

    public static void main(String[] args) {
        //참가자 생성
        String nameOfPerson = InputView.enterNameOfPerson();
        Participants participants = Participants.create(nameOfPerson);

        //사다리 생성
        int ladderHeight = InputView.enterLadderHeight();
        int countOfPerson = participants.tellCountOfPerson();
        Ladder ladder = Ladder.create(ladderHeight, countOfPerson);

        //결과 출력
        ResultView.printLadder(participants, ladder);

    }
}
