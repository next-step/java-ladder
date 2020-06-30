package nextstep.ladder.domain;

import nextstep.ladder.domain.tobe.Ladder;
import nextstep.ladder.domain.tobe.Point;
import nextstep.ladder.domain.tobe.RandomLineCreateStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.stream.IntStream;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.getUsers();
        Prizes prizes = InputView.getPrices();

        Ladder ladder = new Ladder(InputView.getHeight(), users.size(), new RandomLineCreateStrategy());

        ResultView.printResult(users, prizes, ladder);

        UsersPrize usersPrize = new UsersPrize();
        IntStream
                .range(0, users.size())
                .forEach(i -> {
                    int lastPosition = ladder.getLastPosition(new Point(i));
                    usersPrize.add(users.getUser(i), prizes.getPrice(lastPosition));
                });

        String resultQuery = InputView.getResultQuery();
        ResultView.printGameResult(resultQuery, usersPrize);
    }
}
