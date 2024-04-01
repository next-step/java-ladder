package nextstep.ladder.presentation;

import nextstep.ladder.application.LadderService;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserName;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private final LadderService ladderService;
    private final ResultView resultView;
    private final InputView inputView;

    public LadderController(LadderService ladderService, ResultView resultView, InputView inputView) {
        this.ladderService = ladderService;
        this.resultView = resultView;
        this.inputView = inputView;
    }

    public void startGame() {
        resultView.printInputUserNames();
        List<String> userNames = inputView.inputUserNames();
        List<User> users = ladderService.makeUser(userNames);

        resultView.printInputLadderHeight();
        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = ladderService.makeLadder(ladderHeight, users.size());

        resultView.printLadderAndUserNames(ladder, users);
    }
}
