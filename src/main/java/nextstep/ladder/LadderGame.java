package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGame {

    private final BridgeStrategy strategy;

    public LadderGame(BridgeStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        Participants participants = new Participants(getParticipants());
        Height height = new Height(getLadderHeight());

        List<Line> ladder = Ladder.of(participants)
                .create(height, strategy);

        OutputView.printResult(participants, ladder);
    }

    private int getLadderHeight() {
        OutputView.printAskLadderHeightMessage();
        return InputView.getLadderHeight();
    }

    private String getParticipants() {
        OutputView.printParticipantsMessage();
        return InputView.getParticipants();
    }
}
