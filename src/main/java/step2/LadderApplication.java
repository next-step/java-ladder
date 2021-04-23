package step2;

import static step2.view.Message.ALL;
import static step2.view.OutputView.*;
import static step2.view.InputView.*;

import step2.domain.Ladder;
import step2.domain.Prize;
import step2.domain.Prizes;
import step2.domain.RandomLineStrategy;
import step2.domain.Result;
import step2.domain.Users;

public class LadderApplication {

    public static void main(String[] args) {
        Users users = new Users(getUsers());
        Prizes prizes = new Prizes(getPrizes());
        Ladder ladder = new Ladder(getHeight(), users.size(), new RandomLineStrategy());
        printResult();
        printUsers(users);
        printLadder(ladder);
        printPrizes(prizes);
        Result result = ladder.play(users);
        result.reformat(users, prizes);
        while (true) {
            String searchUser = getUser();
            if (searchUser.equals(ALL)) {
                printAll(result, users);
                break;
            }
            Prize prize = result.prize(users.find(searchUser));
            printPrize(prize);
        }
    }
}
