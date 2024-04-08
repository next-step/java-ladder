package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.ConnectionGenerator;
import ladder.domain.player.Players;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

public class LadderGame {

    private final LadderInputView inputView;
    private final LadderOutputView outputView;
    private final ConnectionGenerator connectionGenerator;

    public LadderGame(
            final LadderInputView inputView,
            final LadderOutputView outputView,
            final ConnectionGenerator connectionGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.connectionGenerator = connectionGenerator;
    }

    public void run() {
        try {
            final Players players = Players.from(inputView.readPlayerNames());
            final Ladder ladder = Ladder.of(players, inputView.readLadderHeight(), connectionGenerator);
            outputView.printResult(players, ladder);

        } catch (final IllegalArgumentException e) {
            outputView.printBusinessException(e.getMessage());

        } catch (final Exception e) {
            outputView.printUnexpectedException();
        }
    }
}
