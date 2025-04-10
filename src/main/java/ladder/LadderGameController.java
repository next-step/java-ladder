package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.view.input.ConsoleInputView;
import ladder.view.input.InputView;
import ladder.view.output.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void main(String[] args) {
        LadderGameController game = new LadderGameController(new ConsoleInputView(), new OutputView());
        game.run();
    }

    private void run() {
        String inputNames = inputView.inputPlayerNames();
        Players players = new Players(inputNames);

        int height = inputView.inputLadderHeight();
        Ladder ladder = new Ladder(height, players.count());

        outputView.printResult(players, ladder);
    }
}
