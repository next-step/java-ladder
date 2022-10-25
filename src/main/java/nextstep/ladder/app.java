package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class app {

    public static void main(String[] args) {
        Users userNames = InputView.getUserName();
        int height = InputView.getHeight();
        Ladder ladder = new Ladder(height, userNames.getSize(), new RandomGenerator());

        ResultView.printNames(userNames.getUsers());
        ResultView.printLaddar(ladder);
    }

}
