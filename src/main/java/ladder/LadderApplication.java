package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    private static final String ALL_USER_QUERY_STRING = "all";

    public static void main(String[] args) {
        List<String> userNames = InputView.getUserNames();
        List<String> prizeNames = InputView.getPrizeNames();
        int height = InputView.getHeight();

        LadderGame ladderGame = LadderGame.of(userNames, height, new RandomGenerateStrategy());
        Prizes prizes = Prizes.of(prizeNames, ladderGame.getUsersName().size());

        ResultView.printLadder(ladderGame.getUsersName(), ladderGame.getLines(), prizes.getPrizeNames());

        while (true) {
            String resultUserName = InputView.getResultUserName();
            ResultView.printResultPhrase();

            if (ALL_USER_QUERY_STRING.equals(resultUserName)) {
                printGameResultAll(ladderGame, prizes);
                break;
            }

            printGameResultWith(resultUserName, ladderGame, prizes);
        }

    }

    public static void printGameResultAll(LadderGame ladderGame, Prizes prizes) {
        ladderGame.getUsersName()
                  .forEach(userName -> printGameResultWith(userName, ladderGame, prizes));
    }

    public static void printGameResultWith(String userName, LadderGame ladderGame, Prizes prizes) {
        int point = ladderGame.play(new User(userName));
        ResultView.printResult(userName, prizes.getPrizeByIndex(point).getPrize());
    }

}
