package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.domain.strategy.CoordinateGeneration;
import ladder.domain.strategy.RandomCoordinateGeneration;

import static ladder.ui.InputView.inputHeight;
import static ladder.ui.InputView.inputNames;
import static ladder.ui.ResultView.printLadder;
import static ladder.ui.ResultView.printTitle;

public class LadderController {

    private static final CoordinateGeneration COORDINATE_GENERATION = new RandomCoordinateGeneration();

    public static void main(String[] args) {
        People people = new People(inputNames());
        Height height = new Height(inputHeight());

        Ladder ladder = Ladder.of(people, height, COORDINATE_GENERATION);

        printTitle(people);
        printLadder(ladder);

    }
}
