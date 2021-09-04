package ladder;

import static ladder.view.InputView.inputLadderHeight;
import static ladder.view.InputView.inputUsernames;
import static ladder.view.ResultView.printLadder;
import static ladder.view.ResultView.printUsers;

import ladder.domain.application.LadderService;
import ladder.domain.application.UserService;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.Users;
import ladder.strategy.RandomLineGenerateStrategy;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        LadderService ladderService = new LadderService(new RandomLineGenerateStrategy());

        Users users = userService.createUsers(inputUsernames());
        Ladder ladder = ladderService.createLadder(new LadderHeight(inputLadderHeight()), users);
        userService.shuffleUsers(users);

        printUsers(users.value());
        printLadder(ladder.value());
    }

}
