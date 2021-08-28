package step2;

import step2.domain.Height;
import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.Name;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Name name = new Name(inputView.requireNameOfParticipant());
        Height height = new Height(inputView.requireHeightOfLadder());

        Ladder ladder = new Ladder(name.getCountOfPerson(), height.getValue());

        for (Line line: ladder.getLines()) {
            resultView.printLadderResult(line.getPoints(), name.getCountOfPerson());
            System.out.println();
        }

    }
}
