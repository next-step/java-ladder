package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PointAddStrategy;
import nextstep.ladder.domain.RandomPointAddStrategy;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        InputView userInput = InputView.createByUserInput(userInputScanner);

        PointAddStrategy pointAddStrategy = new RandomPointAddStrategy();
        Ladder ladder = Ladder.create(userInput.getMaxLadderHeight(), userInput.getPlayerSize(), pointAddStrategy);
        OutputView outputView = new OutputView(userInput.getPlayerNames(), ladder);

        System.out.println(outputView.parsePlayerNames());
        System.out.println(outputView.parseLadder());
    }
}
