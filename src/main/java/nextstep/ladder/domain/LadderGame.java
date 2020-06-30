package nextstep.ladder.domain;

import nextstep.ladder.domain.tobe.Ladder;
import nextstep.ladder.domain.tobe.RandomLineCreateStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.getUsers();
        Prizes prizes = InputView.getPrices();

        Ladder ladder = new Ladder(InputView.getHeight(), users.size(), new RandomLineCreateStrategy());

        ResultView.printResult(users, prizes, ladder);

        UsersPrize usersPrize = new UsersPrize(users, prizes, ladder);

        String resultQuery = InputView.getResultQuery();
        ResultView.printGameResult(resultQuery, usersPrize);
    }
}
