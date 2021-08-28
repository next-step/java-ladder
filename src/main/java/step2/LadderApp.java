package step2;

import step2.domain.Height;
import step2.domain.Ladder;
import step2.domain.Name;
import step2.view.InputView;

public class LadderApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Name name = new Name(inputView.requireNameOfParticipant());
        Height height = new Height(inputView.requireHeightOfLadder());

        Ladder ladder = new Ladder(name.getCountOfPerson(), height.getValue());
    }
}
