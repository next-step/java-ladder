package domain;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;

public class LadderGame {
    public static void main(String args[]) {
        String memberArr[] = InputView.typeMemeber();
        int depth = InputView.typeDepth();

        Ladder ladder = Ladder.from(depth, memberArr.length);

        ResultView.printLadder(ladder, memberArr);
    }
}
