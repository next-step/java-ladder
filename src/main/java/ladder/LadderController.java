package ladder;

import ladder.domain.*;
import ladder.domain.strategy.CoordinateGenerator;
import ladder.domain.strategy.RandomCoordinateGenerator;
import ladder.ui.ResultView;

import static ladder.ui.InputView.*;
import static ladder.ui.ResultView.*;
import static ladder.ui.ResultView.printLadder;
import static ladder.ui.ResultView.printTitle;

public class LadderController {

    private static final CoordinateGenerator COORDINATE_GENERATION = new RandomCoordinateGenerator();

    public static void main(String[] args) {
        People people = new People(inputNames());
        Gifts gifts = new Gifts(inputGifts(),people);
        Height height = new Height(inputHeight());

        LadderLines ladder = LadderLines.of(people, height, COORDINATE_GENERATION);

        printTitle(people);
        printLadder(ladder);
        printEndLadder(gifts);

       GameResult gameResult = GameResult.valueOf(people,ladder,gifts);

       printResult(gameResult);

    }
}
