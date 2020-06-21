package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.insertUserLine();

        Prices prices = InputView.getPrices();

        Ladder ladder = new Ladder(new RandomLadderGenerator(users.size(), InputView.getHeight()));

        ResultView.printResult(users, prices, ladder);

        Prices result = new Prices(
                IntStream
                        .range(0, users.size())
                        .map(ladder::getGameResult)
                        .mapToObj(prices::getPrice)
                        .collect(Collectors.toList())
        );

        String resultQuery = InputView.getResultQuery();
        int resultIndex = users.getUserIndex(resultQuery);
        ResultView.printGameResult(result.getPrice(resultIndex));
    }
}
