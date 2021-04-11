package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Scanner;

public class LadderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(inputView, resultView);
        ladderController.run();

        scanner.close();
    }
}
