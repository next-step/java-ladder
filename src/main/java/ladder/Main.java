package ladder;

import ladder.domain.User;
import ladder.util.Generator;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.domain.LadderGame;
import ladder.domain.Line;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> gameContributors = Generator.userGenerate(InputView.findGameContributors());
        List<String> resultList = Generator.resultGenerate(InputView.findResultList());

        LadderGame ladderGame = new LadderGame(gameContributors);
        List<User> users = ladderGame.start();

        List<Line> lines = ladderGame.getLines();
        ResultView.printLadder(ladderGame.drawUserList(), lines, resultList);
        ResultView.printResult(InputView.searchResult(), users, resultList);
    }
}
