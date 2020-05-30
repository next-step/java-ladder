package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        InputView userInput = InputView.createByUserInput(userInputScanner);

        Ladder ladder = Ladder.create(userInput.getMaxLadderHeight(), userInput.getPlayerSize());
        OutputView outputView = new OutputView(userInput.getPlayerNames(), ladder);

        System.out.println(outputView.drawPlayerNames());
        System.out.println(outputView.drawLadder());
    }
}
