package ladder.controller;

import ladder.domain.item.Items;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.line.ConnectionGenerator;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

public class LadderGame {

    private static final String EXIT = "-1";

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
            final Result result = play();
            printGameResult(result);
        } catch (final IllegalArgumentException e) {
            outputView.printBusinessException(e.getMessage());
        } catch (final Exception e) {
            outputView.printUnexpectedException();
        }
    }

    private Result play() {
        final Players players = Players.from(inputView.readPlayerNames());
        final Items items = Items.from(inputView.readItemNames());
        final Ladder ladder = Ladder.of(players, inputView.readLadderHeight(), this.connectionGenerator);
        final Result result = Result.of(players, ladder, items);

        outputView.printLadderResult(players, ladder, items);

        return result;
    }

    private void printGameResult(final Result result) {
        String resultPlayerName = inputView.readResultPlayerName();

        while (!resultPlayerName.equals(EXIT)) {
            outputView.printGameResult(result, resultPlayerName);
            resultPlayerName = inputView.readResultPlayerName();
        }
    }
}
