package ladder;

import ladder.controller.LadderGame;
import ladder.domain.line.RandomConnectionGenerator;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;
import ladder.view.io.Output;
import ladder.view.io.console.ConsoleInput;
import ladder.view.io.console.ConsoleOutput;

public class LadderApplication {

    public static void main(final String[] args) {
        final Output output = new ConsoleOutput();
        final LadderGame ladderGame = new LadderGame(
                new LadderInputView(new ConsoleInput(), output),
                new LadderOutputView(output),
                new RandomConnectionGenerator()
        );

        ladderGame.run();
    }
}
