package ladderWithInterface;

import ladderWithInterface.custom.Gifts;
import ladderWithInterface.custom.Height;
import ladderWithInterface.custom.People;
import ladderWithInterface.custom.RandomCoordinateGenerator;
import ladderWithInterface.engin.CoordinateGenerator;
import ladderWithInterface.engin.Ladder;
import ladderWithInterface.engin.LadderCreator;
import ladderWithInterface.engin.LadderResult;
import ladderWithInterface.factory.LadderFactoryBean;

import static ladderWithInterface.ui.InputView.*;
import static ladderWithInterface.ui.ResultView.printGame;
import static ladderWithInterface.ui.ResultView.printLadder;

public class LadderController {

    private static final CoordinateGenerator COORDINATE_GENERATION = new RandomCoordinateGenerator();

    public static void main(String[] args) {
        People people = new People(inputNames());
        Gifts gifts = new Gifts(inputGifts(), people);
        Height height = new Height(inputHeight());

        LadderCreator ladderCreator = LadderFactoryBean.createLadderFactory();
        Ladder ladder = ladderCreator.create(people.count(), height.find(), COORDINATE_GENERATION);

        printLadder(people, ladder, gifts);

        LadderResult ladderResult = ladder.play();

        printGame(people, ladderResult, gifts);

    }
}
