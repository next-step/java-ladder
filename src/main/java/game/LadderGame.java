package game;

import game.ladder.domain.Ladder;
import game.ladder.view.InputView;
import game.ladder.view.ResultView;

import java.util.List;

/**
 * Created by yusik on 2019/11/09.
 */
public class LadderGame {

    public static final String ALL_COMMAND = "all";

    public void start() {

        InputView inputView = new InputView(System.in);
        ResultView resultView = new ResultView(System.out);
        List<String> names = inputView.receivePlayers();
        List<String> results = inputView.receiveResult();
        int height = inputView.receiveHeight();

        Ladder ladder = new Ladder(names, height, results);
        resultView.render(ladder);

        String command = inputView.receiveResultCommand();
        while (!ALL_COMMAND.equalsIgnoreCase(command)) {
            resultView.renderResult(ladder.getResult(command));
        }
        resultView.renderAllResult(ladder);
    }
}
