package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderSize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private static final String INIT_COMMAND = "";
    private static final String FINISH_COMMAND = "all";

    public static void start() {
        List<String> participants = InputView.getParticipant();
        List<String> prizes = InputView.getPrizesList();
        int height = InputView.getHeight();
        Ladder ladder = Ladder.valueOf(
                new LadderSize(participants.size(), height)
        );
        LadderGame ladderGame =
                new LadderGame(participants, prizes, ladder);
        ResultView.displayLadder(ladderGame);
        selectResult(ladderGame);
    }

    public static void selectResult(LadderGame ladderGame) {
        String command = INIT_COMMAND;
        while (!command.equals(FINISH_COMMAND)) {
            command = InputView.selectResult();
            ResultView.displayResult(command, ladderGame);
        }
    }

    private LadderController() {
    }
}
