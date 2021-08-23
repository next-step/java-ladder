package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameMain {

    public static void main(String[] args) {
        System.out.println("Creating a game now...");
        InputView inputView = InputView.getInstance();
        String[] playerNames = inputView.askPlayerNames();
        int ladderHeight = inputView.askLadderHeight();
        inputView.closeInputScanner();

        OutputView outputView = OutputView.getInstance();
        outputView.showLadder(playerNames, ladderHeight);
    }

}
