package ladder;

import ladder.util.UserGenerator;
import ladder.contoller.InputView;
import ladder.contoller.ResultView;
import ladder.domain.LadderGame;
import ladder.domain.Line;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String gameContributors = InputView.findGameContributors();
        LadderGame ladderGame = new LadderGame(UserGenerator.generate(gameContributors));
        List<Line> lines = ladderGame.ready();
        ResultView.printLadder(ladderGame.drawUserList(), lines);

    }
}
