package ladder;

import ladder.domain.LadderService;
import ladder.domain.model.LadderLines;
import ladder.view.input.InputView;
import ladder.view.input.Users;
import ladder.view.result.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final LadderService ladderService;

    public LadderController(InputView inputView, ResultView resultView, LadderService ladderService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.ladderService = ladderService;
    }

    public void run() {
        Users users = Users.of(inputView.getUserNames());
        LadderLines ladderLines = ladderService.createLadderLines(users.getUserCount(), inputView.getLadderHeight());
        resultView.print(users, ladderLines);
    }
}
