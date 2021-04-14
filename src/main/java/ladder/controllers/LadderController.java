package ladder.controllers;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.factories.LadderLineFactory;
import ladder.views.InputView;
import ladder.views.OutputView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderController {
    public static void run() {
        final Names names = new Names(InputView.names());
        final int ladderHeight = InputView.ladderHeight();
        final Ladder ladder = new Ladder(
                Stream.generate(() -> LadderLineFactory.createAuto(names.names().size())).
                        limit(ladderHeight)
                        .collect(Collectors.toList()));

        OutputView.printResultMessage();
        OutputView.print(names);
        OutputView.print(ladder);
    }
}
