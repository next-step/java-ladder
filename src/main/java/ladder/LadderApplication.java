package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

public class LadderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        LadderController ladderController = new LadderController(inputView, outputView);
        ladderController.startGame();
    }
}
