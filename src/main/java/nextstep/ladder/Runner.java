package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.ResultCollection;
import nextstep.ladder.domain.user.UserCollection;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Runner {
    public static void main(String[] args) {
        UserCollection userCollection = UserCollection.of(InputView.inputPeople());
        ResultCollection resultCollection = ResultCollection.of(InputView.inputResult());
        int height = InputView.inputMaxHeight();
        Ladder ladder = Ladder.init(userCollection.size(), height);
        LadderGame ladderGame = new LadderGame(userCollection, ladder, resultCollection);
        OutputView.drawLadderGame(userCollection, ladder, resultCollection);
        while(true){
            showLadderResult(ladderGame);
        }
    }

    public static void showLadderResult(LadderGame ladderGame) {
        System.out.println();
        String userName = InputView.inputMoveUser();
        if (userName.equals("all")) {
            OutputView.showLadderResult(ladderGame.getAllLadderResult());
            return;
        }
        OutputView.showLadderResult(ladderGame.getLadderResult(userName));
    }
}
