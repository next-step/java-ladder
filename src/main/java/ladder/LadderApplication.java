package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import javax.xml.transform.Result;

public class LadderApplication {
    public static void main(String[] args) throws Exception {
        Users users = InputView.inputUsers();
        LadderRewards ladderRewards = InputView.inputRewards(users.getUsersSize());
        LadderHeight ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(users, ladderHeight);
        ResultView.printLadder(ladderGame, ladderRewards);

        LadderGameResult ladderResult = ladderGame.play(ladderRewards);
        execute(ladderResult);
    }

    private static void execute(LadderGameResult ladderResult) {

        GameStatus gameStatusStatus = new GameStatus(true);
        while(gameStatusStatus.repeatable())
        {
            drawUserResult(ladderResult , gameStatusStatus);
        }
    }

    private static void drawUserResult(LadderGameResult ladderResult, GameStatus gameStatus) {
        User inputUser = new User(InputView.inputUserName());

        if( ResultView.isContinueGame(inputUser.name()) == false )
        {
            gameStatus.stop();
        }

        ResultView.showResultReward(inputUser.name(), ladderResult);

    }
}
