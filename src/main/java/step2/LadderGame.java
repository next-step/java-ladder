package step2;

import step2.model.Height;
import step2.model.Ladder;
import step2.model.Participants;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        String[] nameList = InputView.askNameForLadderGame();
        Participants people = new Participants(nameList);
        Height height = new Height(InputView.askHeightForLadderGame());
        Ladder ladder = new Ladder(height, people.getNumberOfParticipants());
        OutputView.printAll(people, ladder);
    }
}
