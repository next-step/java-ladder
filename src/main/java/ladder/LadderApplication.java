package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String args[]) {
        List<String> participatePersonList =   InputView.getParticipatePerson();
        int countOfPerson = participatePersonList.size();

        int ladderMaxLength = InputView.getLadderMaxLength();

        ResultView.drawLadder(Ladder.of(countOfPerson, ladderMaxLength));


    }
}
