package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.ConsoleInputView;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        List<String> inputNames = inputView.getParticipantNames();
        Participants participants = Participants.from(inputNames);

        int inputHeight = inputView.getHeight();
        Height height = Height.valueOf(inputHeight);
        Ladder ladder = Ladder.of(participants, height);

        ResultView consoleResultView = new ConsoleResultView();
        consoleResultView.printResult(participants, ladder);
    }
}
