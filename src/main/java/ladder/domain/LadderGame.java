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
        List<String> results = inputView.readLadderResults();
        int height = inputView.readLadderHeight();

        Participants participants = new Participants(names);

        int width = participants.size() - 1;

        LadderSize ladderSize = new LadderSize(width, height);
        Ladder ladder = Ladder.generate(ladderSize);
        resultView.printLadder(participants, ladder);
    }
}
