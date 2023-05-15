package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private static final String ALL_MESSAGE = "all";
    private static final String EXIT_MESSAGE = "exit";
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        Ladder ladder = createLadder();
        Result result = new Result(inputView.readResult());
        outputView.printLadder(ladder, result);
        printResultUntilExit(ladder, result);
    }

    private void printResultUntilExit(Ladder ladder, Result result) {
        boolean endFlag = false;
        while (!endFlag) {
            endFlag = printResultOrEnd(ladder, result);
        }
    }

    private boolean printResultOrEnd(Ladder ladder, Result result) {
        String userName = inputView.readUserName();
        if (userName.equals(ALL_MESSAGE)) {
            outputView.printAllResult(ladder, result);
            return false;
        }
        if (userName.equals(EXIT_MESSAGE)) {
            return true;
        }
        outputView.printUserResult(new User(userName), ladder, result);
        return false;
    }

    private Ladder createLadder() {
        Users users = new Users(inputView.readNames());
        Height height = new Height(inputView.readHeight());
        return Ladder.of(users, height, new RandomDrawStrategy());
    }
}
