package step2;

import step2.model.Height;
import step2.model.Ladder;
import step2.model.Participants;
import step2.model.PrizeLocation;
import step2.strategy.RandomDrawStrategy;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.Arrays;

public class LadderGame {

    public static void main(String[] args) {
        String[] nameList = InputView.askNameForLadderGame();
        Participants people = Participants.of(Arrays.asList(nameList));
        PrizeLocation prizeLocation = PrizeLocation.of(InputView.askResultForLadderGame());
        Height height = Height.valueOf(InputView.askHeightForLadderGame());
        Ladder ladder = Ladder.of(height, people.getNumberOfParticipants(), new RandomDrawStrategy());
        ladder.move(people);
        OutputView.printAll(people, ladder, prizeLocation);
    }
}
