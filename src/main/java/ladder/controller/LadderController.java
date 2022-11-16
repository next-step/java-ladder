package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        List<String> nameList = InputView.InputNameList();
        Integer height = InputView.InputHeight();
        Ladder ladder = new Ladder(nameList, height);
        ResultView.printLadder(ladder);
    }
}
