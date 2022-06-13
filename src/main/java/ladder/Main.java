package ladder;

import ladder.domain.LadderLine;
import ladder.domain.User;
import ladder.util.Generator;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.domain.LadderGame;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> gameContributors = Generator.userGenerate(InputView.findGameContributors());
        List<String> resultList = Generator.resultGenerate(InputView.findResultList());
        LadderGame ladderGame = new LadderGame(gameContributors);
        List<LadderLine> ladderLine = ladderGame.create(4);
        Map<String , Integer> result = ladderGame.start();

        ResultView.printLadder(gameContributors, ladderLine, resultList);
        ResultView.printResult(result, InputView.searchResult());


    }
}
