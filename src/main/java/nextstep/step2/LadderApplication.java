package nextstep.step2;

import nextstep.step2.view.InputView;
import nextstep.step2.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Entries entries = new Entries(InputView.inputNames());
        Results results = new Results(InputView.inputResults());
        int ladderHeight = InputView.inputHeight();
        RandomPointGenerator randomPointGenerator = new RandomPointGenerator();

        Ladder ladder = new Ladder(ladderHeight, entries.getHumanList().size(), randomPointGenerator);
        LadderGame ladderGame = new LadderGame(ladder);
        GameResult gameResult = ladderGame.gameStart(entries, results);

        ResultView.printHumans(entries);
        ResultView.printLadder(ladder);
        ResultView.printResults(results);
        ResultView.printGameResults(gameResult);
    }
}
