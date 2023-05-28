package ladder;

import ladder.domain.*;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.BooleanRandomGeneratorStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.from(InputView.names());

        Height height = InputView.height();

        BooleanRandomGeneratorStrategy strategy = new BooleanRandomGeneratorStrategy();
        LadderRequest request = LadderRequest.of(height, Width.from(participants.getSize()), strategy);

        Ladder ladder = Ladder.of(request);

        OutputView.print(participants, ladder);
    }
}
