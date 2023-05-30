package ladder;

import ladder.ui.InputView;
import ladder.ui.PrintView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.saveInput();
        System.out.println(inputView.names);
        Ladder ladder= new Ladder(inputView.ladderHeight, inputView.names.size());
        PrintView.printResult(inputView.names, ladder);

    }

}
