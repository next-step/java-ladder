package nextstep.ladder.presentation;

import nextstep.ladder.application.LadderService;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserName;
import nextstep.ladder.domain.Users;

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
        Users users = ladderService.makeUser(userNames);

        resultView.printInputLadderResult();
        List<String> ladderResults = inputView.inputLadderResult();

        resultView.printInputLadderHeight();
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = ladderService.makeLadder(ladderHeight, users.getUsers().size(), ladderResults);

        resultView.printLadderAndUserNames(ladder, users);
    }

}
