package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        List<String> nameList = InputView.inputNameList();
        List<String> resultList = InputView.inputResultList();
        Integer height = InputView.InputHeight();
        Ladder ladder = new Ladder(nameList, height);
        ResultView.printLadder(ladder);
    }
}
