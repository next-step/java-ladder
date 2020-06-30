package nextstep.ladder.domain;

import nextstep.ladder.domain.tobe.Ladder;
import nextstep.ladder.domain.tobe.Point;
import nextstep.ladder.domain.tobe.RandomLineCreateStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.insertUserLine();

        Prices prices = InputView.getPrices();

        Ladder ladder = new Ladder(InputView.getHeight(), users.size(), new RandomLineCreateStrategy());

        ResultView.printResult(users, prices, ladder);

        Prices resultPrices = new Prices(
                IntStream
                        .range(0, users.size())
                        .map(i ->
                            ladder.getLastPosition(new Point(i))
                        )
                        .mapToObj(prices::getPrice)
                        .collect(Collectors.toList())
        );

        String resultQuery = InputView.getResultQuery();
        ResultView.printGameResult(resultQuery, users, resultPrices);
    }
}
