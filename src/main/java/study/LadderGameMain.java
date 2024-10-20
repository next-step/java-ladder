package study;

import study.core.Ladder;
import study.core.LadderGame;
import study.core.PlayerName;
import study.core.Prize;
import study.core.Result;
import study.view.InputView;
import study.view.ResultView;

import java.util.List;

public class LadderGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<PlayerName> names = inputView.inputNames();
        List<Prize> prizes = inputView.inputResult();
        int height = inputView.inputHeight();

        LadderGame game = new LadderGame(names, height);
        Ladder ladder = game.createLadder();
        resultView.printLadder(names, ladder, prizes);
        Result result = game.play(ladder, prizes);

        PlayerName playerName;
        do {
            playerName = inputView.inputName();
            resultView.printResult(playerName, result);
        } while (!isAllResult(playerName));
    }

    private static boolean isAllResult(PlayerName playerName) {
        return playerName.getName().equals("all");
    }
}
