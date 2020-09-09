package step2;

import step2.model.Height;
import step2.model.Ladder;
import step2.model.Participants;
import step2.strategy.RandomDrawStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        String[] nameList = InputView.askNameForLadderGame();
        Participants people = Participants.of(nameList);
        String[] prizeLocation = InputView.askResultForLadderGame();
        Height height = Height.valueOf(InputView.askHeightForLadderGame());
        Ladder ladder = Ladder.of(height, people.getNumberOfParticipants(), new RandomDrawStrategy());
        OutputView.printAll(people, ladder);
    }
}
