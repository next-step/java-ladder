package step4;

import static step4.view.InputView.inputLadderHeight;
import static step4.view.InputView.inputResultPoint;
import static step4.view.InputView.inputResultUsername;
import static step4.view.InputView.inputUsernames;
import static step4.view.ResultView.printLadderResult;
import static step4.view.ResultView.printResult;

import step4.domain.ladder.Ladder;
import step4.domain.ladder.LadderEndPoints;
import step4.domain.ladder.LadderHeight;
import step4.domain.ladder.LadderResult;
import step4.domain.user.Users;
import step4.strategy.DirectionGenerateStrategy;
import step4.strategy.RandomDirectionGenerateStrategy;

public class Main {

    public static void main(String[] args) {
        DirectionGenerateStrategy lineGenerateStrategy = RandomDirectionGenerateStrategy.getInstance();

        Users users = Users.of(inputUsernames());
        LadderEndPoints endPoints = LadderEndPoints.from(inputResultPoint(), users);

        Ladder ladder = Ladder.createLadder(LadderHeight.of(inputLadderHeight()), users, lineGenerateStrategy);
        LadderResult ladderResult = ladder.createResult(users, endPoints);

        printResult(users.values(), ladder.values(), endPoints.values());
        printLadderResult(inputResultUsername(), users.values(), ladderResult);
    }

}
