package study;

import study.core.LadderGame;
import study.core.Line;
import study.core.PlayerName;
import study.core.Prize;
import study.core.Result;
import study.view.InputView;
import study.view.ResultView;

import java.util.List;
import java.util.stream.Stream;

public class LadderGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<PlayerName> names = inputView.inputNames();
        List<Prize> prizes = inputView.inputResult();
        int height = inputView.inputHeight();

        LadderGame game = new LadderGame(names, height);
        List<Line> ladder= game.createLadder();
        resultView.printLadder(names, ladder, prizes);
        Result result = game.play(ladder, prizes);

        while (true) {
            PlayerName playerName = inputView.inputName();
            resultView.printResult(playerName, result);
            if (playerName.getName().equals("all")) {
                break;
            }
        }
    }
}
