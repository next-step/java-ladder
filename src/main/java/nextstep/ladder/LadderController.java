package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {
    private InputView inputView;
    private OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        List<String> names = inputView.inputNames();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(names, ladderHeight);

        outputView.printResult(ladder);
    }
}
