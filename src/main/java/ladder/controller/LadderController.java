package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.util.RandomUtil;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        List<String> nameList = InputView.inputNameList();
        Players players = new Players(nameList);
        List<String> resultList = InputView.inputResultList();
        Results results = new Results(nameList.size(), resultList);
        Integer height = InputView.inputHeight();
        Ladder ladder = new Ladder(nameList.size(), height, new RandomUtil(), players, results);
        ResultView.printLadder(ladder);

        String resultPlayer = InputView.inputResultPlayer();
        ResultView.printResult(ladder, resultPlayer);
    }
}
