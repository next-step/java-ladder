package ladder;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Random;

public class Main {
    private static void makeLadder() {
        People people = InputView.inputPeople();
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, people, (idx, preConnected) -> !preConnected && new Random().nextBoolean());
        ResultView.printLadder(people, ladder);
    }

    public static void main(String[] args) {
        makeLadder();
    }
}
