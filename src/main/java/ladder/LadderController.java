package ladder;

import ladder.domain.Height;
import ladder.domain.LadderLines;
import ladder.domain.People;
import ladder.domain.strategy.CoordinateGenerator;
import ladder.domain.strategy.RandomCoordinateGenerator;

import static ladder.ui.InputView.inputHeight;
import static ladder.ui.InputView.inputNames;
import static ladder.ui.ResultView.printLadder;
import static ladder.ui.ResultView.printTitle;

public class LadderController {

    private static final CoordinateGenerator COORDINATE_GENERATION = new RandomCoordinateGenerator();

    public static void main(String[] args) {
        People people = new People(inputNames());
        Height height = new Height(inputHeight());

        LadderLines ladder = LadderLines.of(people, height, COORDINATE_GENERATION);

        printTitle(people);
        printLadder(ladder);

    }
}
