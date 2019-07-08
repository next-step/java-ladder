package ladder;

import ladder.domain.DefaultLadderService;
import ladder.domain.DefaultLadderLineFactory;
import ladder.view.input.DefaultInputView;
import ladder.view.result.DefaultResultView;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(
                new DefaultInputView(),
                new DefaultResultView(),
                new DefaultLadderService(new DefaultLadderLineFactory(() -> new Random().nextBoolean()))
        );
        ladderController.run();
    }
}
