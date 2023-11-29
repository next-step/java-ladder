package ladder;

import ladder.domain.*;
import ladder.domain.strategy.CoordinateGenerator;
import ladder.domain.strategy.RandomCoordinateGenerator;

import static ladder.ui.InputView.*;
import static ladder.ui.ResultView.printGame;
import static ladder.ui.ResultView.printLadder;

public class LadderController {

    private static final CoordinateGenerator COORDINATE_GENERATION = new RandomCoordinateGenerator();

    public static void main(String[] args) {
        People people = new People(inputNames());
        Gifts gifts = new Gifts(inputGifts(), people);
        Height height = new Height(inputHeight());

        LadderLines ladder = LadderLines.of(people, height, COORDINATE_GENERATION);

        printLadder(people, ladder, gifts);

        GameResult gameResult = GameResult.valueOf(people, ladder, gifts);

        printGame(gameResult, people);

    }
}
