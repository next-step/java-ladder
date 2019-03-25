package laddergame;

import laddergame.domain.LadderLines;
import laddergame.domain.Participants;
import laddergame.domain.Result;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class ApplicationLauncher {
    public static void main(String[] args) {
        Participants participants = InputView.getParticipants();
        int maximumHeight = InputView.getMaximumHeight();

        ResultView.showResult(new Result(participants, new LadderLines(participants.size(), maximumHeight)));
    }
}