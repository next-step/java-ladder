package nextstep.ladder;

import java.util.List;
import java.util.Scanner;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        List<String> names = inputView.names();
        int height = inputView.height();

        LadderController ladderController = new LadderController();
        ladderController.run(names, height);
    }
}
