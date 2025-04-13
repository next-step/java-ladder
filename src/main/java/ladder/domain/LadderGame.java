package ladder.domain;

import ladder.view.InputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;

    public LadderGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> names = inputView.readParticipantNames();
        int height = inputView.readLadderHeight();

        Participants players = new Participants(names);
    }
}
