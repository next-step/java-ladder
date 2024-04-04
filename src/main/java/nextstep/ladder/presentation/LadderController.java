package nextstep.ladder.presentation;

import nextstep.ladder.application.LadderService;
import nextstep.ladder.domain.*;

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

        resultView.printInputUserNameForResult();
        String userNameForResult = inputView.inputUserNameForResult();

        printGameResult(new GameResult(ladder, users), users, userNameForResult);
    }

    private void printGameResult(GameResult gameResult, Users users, String inputUserName) {
        if (ladderService.isGameResultForAll(inputUserName)) {
            resultView.printGameResultByAllUser(gameResult, users);
            return;
        }

        resultView.printGameResultByUser(gameResult, inputUserName);
    }

}
