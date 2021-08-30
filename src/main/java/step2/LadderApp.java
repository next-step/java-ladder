package step2;

import step2.domain.Height;
import step2.domain.Ladder;
import step2.domain.Name;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        Name name = new Name(InputView.requireNameOfParticipant());
        Height height = new Height(InputView.requireHeightOfLadder());
        Ladder ladder = new Ladder(name.getCountOfPerson(), height.getValue());

        ResultView.printHeader();
        ResultView.printParticipant(name.getParticipantNameList());
        ResultView.printLadderResult(ladder.getLines());
    }
}
