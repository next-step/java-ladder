package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.insertUserLine();

        Prices prices = InputView.getPrices();

        Ladder ladder = new Ladder(new RandomLadderGenerator(users.size(), InputView.getHeight()));

        ResultView.printResult(users, prices, ladder);

        String resultQuery = InputView.getResultQuery();

        int userIndex = users.getUserIndex(resultQuery);
        int gameResult = ladder.getGameResult(userIndex);
        ResultView.printGameResult(prices.getMoney(gameResult));
    }
}
