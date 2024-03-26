package ladder.controller;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Participant;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderConsole {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Participant> participants = inputView.inputPariticipantNames();
        List<String> results = inputView.inputResults();
        int height = inputView.inputHeight();

        Ladder ladder = LadderFactory.generate(participants.size(), results, height);
        outputView.printLadder(ladder, participants);
    }
}
