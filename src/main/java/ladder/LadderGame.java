package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame{
    public static void main(String[] args){
        InputView inputView = new InputView();
        List<String> names = inputView.names();
        int height = inputView.height();
        Ladder ladder = new Ladder(names, height);

        OutputView outputView = new OutputView();
        outputView.printResult(ladder);
    }
}
