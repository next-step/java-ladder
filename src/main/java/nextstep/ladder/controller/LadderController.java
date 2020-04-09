package nextstep.ladder.controller;

import nextstep.ladder.domain.line.Ladder;
import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderSize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private static final String INIT_COMMAND = "";
    private static final String PRINT_ALL_RESULT_COMMAND = "all";

    public static void start() {
        List<String> participants = InputView.getParticipant();
        List<String> prizes = InputView.getPrizesList();
        int height = InputView.getHeight();
        Ladder ladder = Ladder.valueOf(
                new LadderSize(participants.size(), height)
        );
        LadderGame ladderGame = new LadderGame(participants, prizes, ladder);
        ResultView.displayLadder(ladderGame);
        selectResult(ladderGame);
    }

    private static void selectResult(LadderGame ladderGame) {
        String command = INIT_COMMAND;
        while (!command.equals(PRINT_ALL_RESULT_COMMAND)) {
            command = InputView.selectResult();
            displayResult(command, ladderGame);
        }
    }

    private static void displayResult(String command, LadderGame ladderGame) {
        if (PRINT_ALL_RESULT_COMMAND.equals(command)) {
            ResultView.displayResult(ladderGame.resultAll());
            return;
        }
        ResultView.displayResult(ladderGame.result(command));
    }

    private LadderController() {
    }
}
