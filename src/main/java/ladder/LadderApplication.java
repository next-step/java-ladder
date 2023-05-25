package ladder;

import ladder.domain.*;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.BooleanRandomGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.from(InputView.names());

        Height height = InputView.height();

        BooleanRandomGenerator strategy = new BooleanRandomGenerator();
        LadderRequest request = LadderRequest.of(height, Width.from(participants.getLine()), strategy);

        Ladder ladder = Ladder.of(request);

        OutputView.print(participants, ladder);
    }
}
