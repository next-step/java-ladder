package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        List<String> nameList = InputView.inputNameList();
        List<String> resultList = InputView.inputResultList();
        Integer height = InputView.InputHeight();
        Players players = new Players(nameList);
        Results results = new Results(nameList.size(), resultList);
        Ladder ladder = new Ladder(nameList.size(), height, players, results);
        ResultView.printLadder(ladder);
    }
}
