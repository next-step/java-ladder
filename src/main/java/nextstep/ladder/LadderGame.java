package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Participants participants = getParticipants();
        Height height = getHeight();
        Ladder ladder = Ladder.of(participants, height);
        resultView.printResult(participants, ladder);
    }

    private Participants getParticipants() {
        List<String> inputNames = inputView.getParticipantNames();
        return Participants.from(inputNames);
    }

    private Height getHeight() {
        int inputHeight = inputView.getHeight();
        return Height.valueOf(inputHeight);
    }
}
