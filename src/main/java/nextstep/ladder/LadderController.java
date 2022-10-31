package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {
    private InputView inputView;
    private OutputView outputView;

    private LadderFactory ladderFactory;
    public LadderController(InputView inputView, OutputView outputView, LadderFactory ladderFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderFactory = ladderFactory;
    }

    public void startGame() {
        List<String> names = inputView.inputNames();
        List<String> results = inputView.inputResult();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = ladderFactory.generateLadder(results, names, ladderHeight);
        outputView.printResult(ladder);
        outputView.printUserResult(ladder);
    }
}
