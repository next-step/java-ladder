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
        ResultInput resultInput = ResultInput.of(inputView.readResult());
        ResultUser resultUser = ResultUser.of(ladder, resultInput);

        outputView.printLadder(ladder, resultInput);
        printResultUntilExit(ladder, resultUser);
    }

    private void printResultUntilExit(Ladder ladder, ResultUser resultUser) {
        boolean endFlag = false;
        while (!endFlag) {
            endFlag = printResultOrEnd(ladder, resultUser);
        }
    }

    private boolean printResultOrEnd(Ladder ladder, ResultUser resultUser) {
        String userName = inputView.readUserName();
        if (userName.equals(ALL_MESSAGE)) {
            outputView.printAllResult(resultUser);
            return false;
        }
        if (userName.equals(EXIT_MESSAGE)) {
            return true;
        }
        outputView.printUserResult(new User(userName), resultUser);
        return false;
    }

    private Ladder createLadder() {
        Users users = Users.of(inputView.readNames());
        Height height = new Height(inputView.readHeight());
        return Ladder.of(users, height, new RandomDrawStrategy());
    }
}
