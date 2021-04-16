package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.Player;
import ladder.domain.Prize;

import java.util.Map;

public class PrizeResultView {
    private final LadderResult ladderResult;
    private final Prize prize;

    public PrizeResultView(LadderResult ladderResult, Prize prize) {
        this.ladderResult = ladderResult;
        this.prize = prize;
    }

    public void printPrizeResult(PrizeInputView inputView) {
        System.out.println("실행 결과");
        if (inputView.isAll()) {
            printResultAll();
            return;
        }
        printResult(inputView.getPlayerName());
    }

    public void printResult(String playerName) {
        System.out.println(ladderResult.playersPrize(new Player(playerName), prize));
    }

    public void printResultAll() {
        Map<String, String> allResult = ladderResult.playersPrizeAll(prize);
        allResult.forEach((player, result) -> System.out.println(player + " : " + result));
    }
}
