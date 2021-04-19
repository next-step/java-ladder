package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class PrizeResultView {
    private final LadderResult ladderResult;
    private final Prize prize;

    public PrizeResultView(ResultView resultView, Prize prize) {
        this.ladderResult = resultView.getLadderResult();
        this.prize = prize;
    }

    public void printPrizeResult(PrizeInputView inputView, Players players) {
        System.out.println("실행 결과");
        if (inputView.isAll()) {
            printResultAll(players);
            return;
        }
        printResult(players, inputView.getPlayerName());
    }

    public void printResult(Players players, String playerName) {
        System.out.println(ladderResult.playersPrize(new PrizePlayer(players, new Player(playerName)), prize));
    }

    public void printResultAll(Players players) {
        Map<String, String> allResult = ladderResult.playersPrizeAll(new PrizePlayer(players), prize);
        allResult.forEach((player, result) -> System.out.println(player + " : " + result));
    }
}
