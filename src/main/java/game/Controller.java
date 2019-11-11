package game;

import game.ladder.domain.Ladder;
import game.ladder.view.InputView;
import game.ladder.view.ResultView;

import java.util.List;

/**
 * Created by yusik on 2019/11/09.
 */
public class Controller {

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        InputView inputView = new InputView(System.in);
        ResultView resultView = new ResultView(System.out);
        List<String> names = inputView.receivePlayers();
        int height = inputView.receiveHeight();

        Ladder ladder = new Ladder(names, height);
        resultView.render(ladder);

    }
}
