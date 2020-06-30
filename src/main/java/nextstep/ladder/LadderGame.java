package nextstep.ladder;

import nextstep.ladder.domain.ladders.Ladder;
import nextstep.ladder.domain.result.UsersPrize;
import nextstep.ladder.domain.prizes.Prizes;
import nextstep.ladder.domain.ladders.RandomLineCreateStrategy;
import nextstep.ladder.domain.users.Users;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.getUsers();
        Prizes prizes = InputView.getPrices();

        Ladder ladder = new Ladder(InputView.getHeight(), users.size(), new RandomLineCreateStrategy());

        ResultView.printResult(users, prizes, ladder);

        UsersPrize usersPrize = new UsersPrize(users, prizes, ladder);

        while(true) {
            if (ResultView.printGameResult(InputView.getResultQuery(), usersPrize)) {
                break;
            }
        }
    }
}
