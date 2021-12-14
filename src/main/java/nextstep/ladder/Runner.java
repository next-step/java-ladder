package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.ladder.LadderInput;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.ResultCollection;
import nextstep.ladder.domain.user.UserCollection;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Runner {
    public static void main(String[] args) {
        UserCollection userCollection = UserCollection.of(InputView.inputPeople());
        ResultCollection resultCollection = ResultCollection.of(InputView.inputResult());
        LadderInput ladderInput = new LadderInput(userCollection, resultCollection);

        int height = InputView.inputMaxHeight();
        Ladder ladder = Ladder.init(ladderInput.size(), height);
        LadderGame ladderGame = new LadderGame(ladder, ladderInput);

        OutputView.drawLadderGame(userCollection, ladder, resultCollection);
        while(true){
            try {
                showLadderResult(ladderGame);
            }catch (ArrayIndexOutOfBoundsException e){
                OutputView.wrongUserCheck();
            }
        }
    }

    public static void showLadderResult(LadderGame ladderGame) throws ArrayIndexOutOfBoundsException{
        String userName = InputView.inputMoveUser();
        if (userName.equals("all")) {
            OutputView.showLadderResult(ladderGame.getAllLadderResult());
            return;
        }
        OutputView.showLadderResult(ladderGame.getLadderResult(userName));
    }
}
