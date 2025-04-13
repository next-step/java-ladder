package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> names = inputView.readParticipantNames();
        int height = inputView.readLadderHeight();

        Participants participants = new Participants(names);
        int width = participants.size() - 1;

        Ladder ladder = Ladder.generate(width, height);
        resultView.printLadder(participants, ladder);
    }
}
