package ladder;

import ladder.domain.User;
import ladder.util.Generator;
import ladder.contoller.InputView;
import ladder.contoller.ResultView;
import ladder.domain.LadderGame;
import ladder.domain.Line;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String gameContributors = InputView.findGameContributors();
        List<User> resultList = Generator.generate(InputView.findResultList());
        LadderGame ladderGame = new LadderGame(Generator.generate(gameContributors));
        List<Line> lines = ladderGame.getLines();
//        ladderGame.start();
        ResultView.printLadder(ladderGame.drawUserList(), lines);
    }
}
