package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.view.dto.LadderDTO;


public class LadderApplication {
    private static final String ALL_USER_QUERY_STRING = "all";

    public static void main(String[] args) {
        LadderDTO ladderInfos = InputView.getLadderDTO();
        LadderGame ladderGame = LadderGame.of(ladderInfos.getUserNames(), ladderInfos.getHeight(), new RandomGenerateStrategy());
        Prizes prizes = Prizes.of(ladderInfos.getPrizeNames(), ladderGame.getUsersName().size());

        ResultView.printLadder(ladderGame.getUsersName(), ladderGame.getLines(), prizes.getPrizeNames());
        printGameResult(ladderGame, prizes);
    }

    public static void printGameResult(LadderGame ladderGame, Prizes prizes) {
        String resultUserName = InputView.getResultUserName();
        ResultView.printResultPhrase();

        if (ALL_USER_QUERY_STRING.equals(resultUserName)) {
            printGameResultAll(ladderGame, prizes);
            return;
        }

        printGameResultWith(resultUserName, ladderGame, prizes);
        printGameResult(ladderGame, prizes);
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
