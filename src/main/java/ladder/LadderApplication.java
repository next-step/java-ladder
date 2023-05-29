package ladder;

import ladder.domain.*;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.BooleanRandomGeneratorStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.from(InputView.names());
        LadderResultValue results = InputView.results();

        Height height = InputView.height();

        BooleanRandomGeneratorStrategy strategy = new BooleanRandomGeneratorStrategy();
        LadderRequest request = LadderRequest.of(height, Width.from(participants.getSize()), strategy);

        Ladder ladder = Ladder.of(request);

        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        OutputView.print(ladderGame);
        ladderGame.process();

        Participant participant = InputView.selectResult();
        PrintDelegator printDelegator = ladderGame.getParticipantPosition(participant);

        OutputView.selectResultPrint(printDelegator);

    }
}
