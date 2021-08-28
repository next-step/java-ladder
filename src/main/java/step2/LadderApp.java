package step2;

import step2.domain.Ladder;
import step2.domain.Name;
import step2.view.InputView;

public class LadderApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Name nameOfParticipant = new Name(inputView.requireNameOfParticipant());
        Ladder ladder = new Ladder(inputView.requireHeightOfLadder());
        
    }
}
