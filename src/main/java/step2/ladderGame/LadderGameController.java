package step2.ladderGame;

import step2.ladderGame.domain.ladder.Ladder;
import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineRandomGenerationStrategy;
import step2.ladderGame.domain.user.Users;
import step2.ladderGame.view.InputView;
import step2.ladderGame.view.ResultView;

import java.util.Scanner;

public class LadderGameController {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            ResultView resultView = new ResultView();

            String userNames = inputView.inputUserNames();
            Users users = new Users(userNames);
            int height = inputView.inputHeight();

            Ladder ladder = new Ladder(users.getUserCount(), new horizontalLineRandomGenerationStrategy(), height);

            resultView.printUserNames(users);
            resultView.printLadder(ladder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
