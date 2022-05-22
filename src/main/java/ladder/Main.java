package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String gameContributors = InputView.findGameContributors();
        LadderGame ladderGame = new LadderGame(UserGenerator.generate(gameContributors));
        List<Line> lines = ladderGame.ready();
        ResultView.printLadder(ladderGame.drawUserList(), lines);

    }
}
