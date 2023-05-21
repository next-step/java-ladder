package ladder;

import ladder.domain.*;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.RandomLadderStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.from(InputView.names());

        Height height = InputView.maxHeight();

        RandomLadderStrategy strategy = new RandomLadderStrategy();
        LadderRequest request = LadderRequest.of(height, Width.from(participants.getLine()), strategy);

        Ladder ladder = Ladder.of(request, participants);

        OutputView.print(participants, ladder);
    }
}
